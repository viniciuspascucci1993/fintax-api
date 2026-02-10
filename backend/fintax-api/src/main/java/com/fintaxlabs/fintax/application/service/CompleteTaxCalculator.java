package com.fintaxlabs.fintax.application.service;

import java.math.BigDecimal;

public class CompleteTaxCalculator extends AbstractTaxCalculator {
    @Override
    protected BigDecimal calculateTax(BigDecimal taxableBase) {
        return taxableBase.multiply(new BigDecimal("0.275"));
    }
}
