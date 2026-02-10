package com.fintaxlabs.fintax.application.resolver;

import com.fintaxlabs.fintax.application.service.CompleteTaxCalculator;
import com.fintaxlabs.fintax.application.service.SimplifiedTaxCalculator;
import com.fintaxlabs.fintax.domain.enums.TaxRegime;
import com.fintaxlabs.fintax.domain.exception.DomainException;
import com.fintaxlabs.fintax.domain.service.TaxCalculator;

import java.util.Map;

public class TaxCalculatorFactory {

    private final Map<TaxRegime, TaxCalculator> calculators;
    public TaxCalculatorFactory(
            SimplifiedTaxCalculator simplified,
            CompleteTaxCalculator complete
    ) {
        this.calculators = Map.of(
                TaxRegime.SIMPLIFIED, simplified,
                TaxRegime.COMPLETE, complete
        );
    }

    public TaxCalculator resolve(TaxRegime regime) {
        TaxCalculator calculator = calculators.get(regime);

        if (calculator == null) {
            throw new DomainException("No calculator for regime: " + regime);
        }

        return calculator;
    }
}
