package com.fintaxlabs.fintax.domain.model.factory;

import com.fintaxlabs.fintax.domain.enums.TaxRegime;
import com.fintaxlabs.fintax.domain.taxrule.TaxTable;

public interface TaxTableFactory {

    TaxTable forYear(int fiscalYear, TaxRegime mode);
}
