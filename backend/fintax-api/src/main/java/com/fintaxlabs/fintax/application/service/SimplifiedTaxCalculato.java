package com.fintaxlabs.fintax.application.service;

import com.fintaxlabs.fintax.domain.taxrule.TaxTable;

public class SimplifiedTaxCalculato extends AbstractTaxCalculator{

    public SimplifiedTaxCalculato(TaxTable taxTable) {
        super(taxTable);
    }
}
