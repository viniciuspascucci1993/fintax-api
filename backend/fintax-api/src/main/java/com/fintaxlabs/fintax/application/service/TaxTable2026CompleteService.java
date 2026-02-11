package com.fintaxlabs.fintax.application.service;

import com.fintaxlabs.fintax.domain.taxrule.TaxTable;

import java.math.BigDecimal;

public class TaxTable2026CompleteService implements TaxTable {
    @Override
    public BigDecimal calculate(BigDecimal taxableBase) {
        return taxableBase.multiply(new BigDecimal("0.275"));
    }
}
