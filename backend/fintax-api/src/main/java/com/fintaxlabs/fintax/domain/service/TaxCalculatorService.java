package com.fintaxlabs.fintax.domain.service;

import com.fintaxlabs.fintax.domain.model.TaxDeclaration;
import com.fintaxlabs.fintax.domain.model.TaxResult;

public interface TaxCalculatorService {

    TaxResult calculate(TaxDeclaration declaration);
}
