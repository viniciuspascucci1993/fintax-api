package com.fintaxlabs.fintax.application.usecase;

import com.fintaxlabs.fintax.domain.model.TaxDeclaration;
import com.fintaxlabs.fintax.domain.model.TaxResult;
import com.fintaxlabs.fintax.domain.service.TaxCalculator;

public class SimulateTaxUseCase {

    private final TaxCalculator taxCalculator;

    public SimulateTaxUseCase(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public TaxResult execute(TaxDeclaration taxDeclaration) {
        return taxCalculator.calculate(taxDeclaration);
    }
}
