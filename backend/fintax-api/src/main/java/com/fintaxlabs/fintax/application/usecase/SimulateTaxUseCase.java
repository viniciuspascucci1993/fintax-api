package com.fintaxlabs.fintax.application.usecase;

import com.fintaxlabs.fintax.application.port.output.TaxDeclarationRepository;
import com.fintaxlabs.fintax.application.port.output.TaxResultRepository;
import com.fintaxlabs.fintax.application.resolver.TaxCalculatorFactory;
import com.fintaxlabs.fintax.domain.model.TaxDeclaration;
import com.fintaxlabs.fintax.domain.model.TaxResult;
import com.fintaxlabs.fintax.domain.taxrule.TaxTable;

import java.math.BigDecimal;
import java.util.UUID;

public class SimulateTaxUseCase {

    private final TaxCalculatorFactory factory;
    private final TaxDeclarationRepository taxDeclarationRepository;
    private final TaxResultRepository resultRepository;

    public SimulateTaxUseCase(TaxCalculatorFactory factory,
                              TaxDeclarationRepository taxDeclarationRepository,
                              TaxResultRepository resultRepository) {
        this.factory = factory;
        this.taxDeclarationRepository = taxDeclarationRepository;
        this.resultRepository = resultRepository;
    }

    public TaxResult execute(TaxDeclaration taxDeclaration) {

        if (taxDeclaration.getId() == null) {
            taxDeclaration.setId(UUID.randomUUID());
        }

        if (taxDeclaration.getTaxPayer().getId() == null) {
            taxDeclaration.getTaxPayer().setId(UUID.randomUUID());
        }

        // 3 - Calcular renda anual
        BigDecimal annualIncome = taxDeclaration.getIncomes().stream()
                .map(income -> income.getAmount().multiply(BigDecimal.valueOf(12)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 4 - Calcular deduções anuais
        BigDecimal annualDeductions = taxDeclaration.getDeductions().stream()
                .map(deduction -> deduction.getAmount().multiply(BigDecimal.valueOf(12)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 5 - Base tributável
        BigDecimal taxableBase = annualIncome
                .subtract(annualDeductions)
                .max(BigDecimal.ZERO);

        // 6 - Resolver tabela pelo regime
        TaxTable calculator =
                factory.resolve(taxDeclaration.getRegime());

        // 7 - Calcular imposto
        BigDecimal taxDue = calculator.calculate(taxableBase);

        // 8 - Montar resultado
        TaxResult result = new TaxResult(
                taxDeclaration.getId(),                 // taxDeclarationId
                taxDeclaration.getRegime(),             // taxRegime
                annualIncome,                           // grossIncome
                annualDeductions,                       // totalDeductions
                taxableBase,                            // taxableBase
                taxDue,                                 // taxDue
                BigDecimal.ZERO                         // refund (ainda não implementado)
        );

        // 9 - Persistir
        taxDeclarationRepository.save(taxDeclaration);
        resultRepository.save(result);

        return result;

    }
}
