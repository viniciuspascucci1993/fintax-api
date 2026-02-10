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

        // Calcula SIMPLIFIED
        TaxResult simplifiedResult =
                taxCalculatorFactory
                        .resolve(TaxRegime.SIMPLIFIED)
                        .calculate(declaration);

        // Calcula COMPLETE
        TaxResult completeResult =
                taxCalculatorFactory
                        .resolve(TaxRegime.COMPLETE)
                        .calculate(declaration);

        BigDecimal simplifiedTax = simplifiedResult.getTaxDue();
        BigDecimal completeTax = completeResult.getTaxDue();

        TaxRegime bestOption =
                simplifiedTax.compareTo(completeTax) <= 0
                        ? TaxRegime.SIMPLIFIED
                        : TaxRegime.COMPLETE;

        BigDecimal difference =
                simplifiedTax.subtract(completeTax).abs();

        // criar o result = diferença
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
