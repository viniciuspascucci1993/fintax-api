package com.fintaxlabs.fintax.shared.util;

import com.fintaxlabs.fintax.domain.model.TaxAssessmentDeclaration;

import java.math.BigDecimal;

public class AnnualCalculations {

    public static BigDecimal calculateAnnualDeduction(TaxAssessmentDeclaration declaration) {

        // Quanto essa pessoa pode deduzir no ANO, somando todas as deduções declaradas?
        return declaration.getDeductions().stream()
                .map(deduction -> deduction.getAmount().multiply(BigDecimal.valueOf(12)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static BigDecimal calculateAnnualIncome(TaxAssessmentDeclaration declaration) {

        // Quanto essa pessoa ganhou no ANO, somando todas as rendas declaradas?
        return declaration.getIncomes().stream()
                .map(income -> income.getAmount().multiply(BigDecimal.valueOf(12)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
