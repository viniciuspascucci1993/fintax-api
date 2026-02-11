package com.fintaxlabs.fintax.application.resolver;

import com.fintaxlabs.fintax.application.service.TaxTable2026CompleteService;
import com.fintaxlabs.fintax.application.service.TaxTable2026SimplifiedService;
import com.fintaxlabs.fintax.domain.enums.TaxRegime;
import com.fintaxlabs.fintax.domain.exception.DomainException;
import com.fintaxlabs.fintax.domain.service.TaxCalculator;
import com.fintaxlabs.fintax.domain.taxrule.TaxTable;

import java.util.Map;

public class TaxCalculatorFactory {

    private final Map<TaxRegime, TaxTable> calculators;
    public TaxCalculatorFactory(
            TaxTable2026SimplifiedService simplified,
            TaxTable2026CompleteService complete
    ) {
        this.calculators = Map.of(
                TaxRegime.SIMPLIFIED, simplified,
                TaxRegime.COMPLETE, complete
        );
    }

    public TaxTable resolve(TaxRegime regime) {
        TaxTable calculator = calculators.get(regime);

        if (calculator == null) {
            throw new DomainException("No calculator for regime: " + regime);
        }

        return calculator;
    }
}
