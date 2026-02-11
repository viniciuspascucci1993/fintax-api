package com.fintaxlabs.fintax.application.usecase;

import com.fintaxlabs.fintax.application.resolver.TaxCalculatorFactory;
import com.fintaxlabs.fintax.domain.enums.TaxRegime;
import com.fintaxlabs.fintax.domain.exception.DomainException;
import com.fintaxlabs.fintax.domain.model.TaxComparisonResult;
import com.fintaxlabs.fintax.domain.model.TaxDeclaration;
import com.fintaxlabs.fintax.domain.model.TaxResult;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

public class CompareTaxRegimesUseCase {

    private final TaxCalculatorFactory taxCalculatorFactory;

    public CompareTaxRegimesUseCase(TaxCalculatorFactory taxCalculatorFactory) {
        this.taxCalculatorFactory = taxCalculatorFactory;
    }

    public TaxComparisonResult execute(TaxDeclaration declaration) {

        if (declaration == null) {
            throw new DomainException("Tax declaration cannot be null");
        }

        // 1 - Calcular renda anual
        BigDecimal annualIncome = declaration.getIncomes().stream()
                .map(income -> income.getAmount().multiply(BigDecimal.valueOf(12)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 2 - Calcular deduções anuais
        BigDecimal annualDeductions = declaration.getDeductions().stream()
                .map(deduction -> deduction.getAmount().multiply(BigDecimal.valueOf(12)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 3 - Base tributável
        BigDecimal taxableBase = annualIncome
                .subtract(annualDeductions)
                .max(BigDecimal.ZERO);

        // 4 - Calcular SIMPLIFIED
        BigDecimal simplifiedTax =
                taxCalculatorFactory
                        .resolve(TaxRegime.SIMPLIFIED)
                        .calculate(taxableBase);

        // 5 - Calcular COMPLETE
        BigDecimal completeTax =
                taxCalculatorFactory
                        .resolve(TaxRegime.COMPLETE)
                        .calculate(taxableBase);

        // 6 - Melhor opção
        TaxRegime bestOption =
                simplifiedTax.compareTo(completeTax) <= 0
                        ? TaxRegime.SIMPLIFIED
                        : TaxRegime.COMPLETE;

        BigDecimal difference =
                simplifiedTax.subtract(completeTax).abs();

        // 7 - Criar TaxResult para cada regime
        TaxResult simplifiedResult = new TaxResult(
                declaration.getId(),
                TaxRegime.SIMPLIFIED,
                annualIncome,
                annualDeductions,
                taxableBase,
                simplifiedTax,
                BigDecimal.ZERO
        );

        TaxResult completeResult = new TaxResult(
                declaration.getId(),
                TaxRegime.COMPLETE,
                annualIncome,
                annualDeductions,
                taxableBase,
                completeTax,
                BigDecimal.ZERO
        );

        Map<TaxRegime, TaxResult> results = new EnumMap<>(TaxRegime.class);
        results.put(TaxRegime.SIMPLIFIED, simplifiedResult);
        results.put(TaxRegime.COMPLETE, completeResult);

        return new TaxComparisonResult(
                bestOption,
                difference,
                results
        );
    }
}
