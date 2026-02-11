package com.fintaxlabs.fintax.domain.taxrule;

import java.math.BigDecimal;

public interface TaxTable {

    BigDecimal calculate(BigDecimal taxableBase);
}
