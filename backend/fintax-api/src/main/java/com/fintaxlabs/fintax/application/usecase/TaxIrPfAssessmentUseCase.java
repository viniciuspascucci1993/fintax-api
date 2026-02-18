package com.fintaxlabs.fintax.application.usecase;

import com.fintaxlabs.fintax.domain.enums.TaxAssessmentStatus;
import com.fintaxlabs.fintax.domain.enums.TaxRegime;
import com.fintaxlabs.fintax.domain.model.TaxAssessment;
import com.fintaxlabs.fintax.domain.model.TaxAssessmentDeclaration;
import com.fintaxlabs.fintax.domain.model.TaxAssessmentSummary;
import com.fintaxlabs.fintax.domain.model.factory.TaxTableFactory;
import com.fintaxlabs.fintax.domain.taxrule.TaxTable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static com.fintaxlabs.fintax.application.messages.TaxAssessmentMessageBuilder.buildMessages;
import static com.fintaxlabs.fintax.shared.util.AnnualCalculations.calculateAnnualDeduction;
import static com.fintaxlabs.fintax.shared.util.AnnualCalculations.calculateAnnualIncome;

public class TaxIrPfAssessmentUseCase {

    private final TaxTableFactory taxTableFactory;

    private static final BigDecimal SIMPLIFIED_LIMIT =
            new BigDecimal("16754.34");

    private static final BigDecimal SIMPLIFIED_DISCOUNT =
            new BigDecimal("0.20");

    public TaxIrPfAssessmentUseCase(TaxTableFactory taxTableFactory) {
        this.taxTableFactory = taxTableFactory;
    }

    public TaxAssessment execute(TaxAssessmentDeclaration declaration) {

        BigDecimal taxableBase;

        // 1 -ano fiscal
        int fiscalYear = declaration.getFiscalYear();

        // 2 - Normalizar rendas (mensal → anual)
        BigDecimal annualIncome = calculateAnnualIncome(declaration);

        // 3 - Normalizar deduções
        BigDecimal annualDeductions = calculateAnnualDeduction(declaration);

        // 4 - Base Tributável
        if (declaration.getRegime() == TaxRegime.SIMPLIFIED) {

            // Desconto simplificado: 20% limitado
            BigDecimal simplifiedDiscount =
                    annualIncome.multiply(SIMPLIFIED_DISCOUNT);

            simplifiedDiscount = simplifiedDiscount.min(SIMPLIFIED_LIMIT);

            taxableBase = annualIncome.subtract(simplifiedDiscount);

        } else {

            taxableBase = annualIncome.subtract(annualDeductions);
        }

        taxableBase = taxableBase.max(BigDecimal.ZERO);

        // 5 - Selecionar Tabela
        TaxTable taxTable  = taxTableFactory.forYear(fiscalYear, declaration.getRegime());

        // 6. Calcular imposto
        BigDecimal taxDue = taxTable.calculate(taxableBase);

        // 7 - Calcular total retido no ano
        BigDecimal totalTaxWithHeld = declaration.getIncomes().stream()
                .map(income -> income.getTaxWithheld()
                        .multiply(BigDecimal.valueOf(12)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 8 - Valor mensal equivalente
        BigDecimal monthlyTaxDue = taxDue
                .divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);

        // 9 - Comparar retido vs devido
        BigDecimal refund = BigDecimal.ZERO;
        BigDecimal amountToPay = BigDecimal.ZERO;

        if (totalTaxWithHeld.compareTo(taxDue) > 0) {
            refund = totalTaxWithHeld.subtract(taxDue);
        } else {
            amountToPay = taxDue.subtract(totalTaxWithHeld);
        }

        boolean darfRequired = amountToPay.compareTo(BigDecimal.ZERO) > 0;
        BigDecimal installmentValue = calculateInstallmentValue(amountToPay);

        // Status
        TaxAssessmentStatus status;

        if (taxDue.compareTo(BigDecimal.ZERO) == 0) {
            status = TaxAssessmentStatus.EXEMPT;
        } else if (refund.compareTo(BigDecimal.ZERO) > 0) {
            status = TaxAssessmentStatus.TAX_REFUND;
        } else {
            status = TaxAssessmentStatus.TAX_DUE;
        }

        // 8 - Messages
        List<String> messages = buildMessages(status, fiscalYear);

        // 9. Retorno
        return new TaxAssessment(
                fiscalYear,
                declaration.getTaxpayer(),
                new TaxAssessmentSummary(
                        annualIncome,
                        annualDeductions,
                        taxableBase,
                        taxDue,
                        totalTaxWithHeld,
                        amountToPay,
                        refund,
                        monthlyTaxDue,
                        darfRequired,
                        installmentValue,
                        status
                ),
                messages
        );
    }

    private static BigDecimal calculateInstallmentValue(BigDecimal amountToPay) {

        if (amountToPay.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal minimumInstallment = new BigDecimal("50.00");
        int maxInstallments = 8;

        BigDecimal tentativeInstallment =
                amountToPay.divide(BigDecimal.valueOf(maxInstallments), 2, RoundingMode.HALF_UP);

        if (tentativeInstallment.compareTo(minimumInstallment) >= 0) {
            return tentativeInstallment;
        }

        return amountToPay.setScale(2, RoundingMode.HALF_UP);
    }
}
