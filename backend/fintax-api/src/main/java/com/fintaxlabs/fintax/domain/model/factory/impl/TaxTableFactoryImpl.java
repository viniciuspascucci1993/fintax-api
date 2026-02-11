package com.fintaxlabs.fintax.domain.model.factory.impl;

import com.fintaxlabs.fintax.application.service.TaxTable2026CompleteService;
import com.fintaxlabs.fintax.application.service.TaxTable2026SimplifiedService;
import com.fintaxlabs.fintax.domain.enums.TaxRegime;
import com.fintaxlabs.fintax.domain.model.factory.TaxTableFactory;
import com.fintaxlabs.fintax.domain.taxrule.TaxTable;

public class TaxTableFactoryImpl implements TaxTableFactory {

    @Override
    public TaxTable forYear(int fiscalYear, TaxRegime mode) {

        if (fiscalYear == 2026 && mode == TaxRegime.SIMPLIFIED) {
            return new TaxTable2026SimplifiedService();
        }

        if (fiscalYear == 2026 && mode == TaxRegime.COMPLETE) {
            return new TaxTable2026CompleteService();
        }

        throw new IllegalArgumentException(
                "No tax table defined for fiscal year " + fiscalYear
        );
    }
}
