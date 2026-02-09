package com.fintaxlabs.fintax.application.usecase;

import com.fintaxlabs.fintax.application.port.output.TaxDeclarationRepository;
import com.fintaxlabs.fintax.application.port.output.TaxResultRepository;
import com.fintaxlabs.fintax.domain.model.TaxDeclaration;
import com.fintaxlabs.fintax.domain.model.TaxResult;
import com.fintaxlabs.fintax.domain.service.TaxCalculator;

public class SimulateTaxUseCase {

    private final TaxCalculator taxCalculator;
    private final TaxDeclarationRepository taxDeclarationRepository;

    private final TaxResultRepository resultRepository;

    public SimulateTaxUseCase(TaxCalculator taxCalculator,
                              TaxDeclarationRepository taxDeclarationRepository,
                              TaxResultRepository resultRepository) {
        this.taxCalculator = taxCalculator;
        this.taxDeclarationRepository = taxDeclarationRepository;
        this.resultRepository = resultRepository;
    }

    public TaxResult execute(TaxDeclaration taxDeclaration) {
        TaxResult result = taxCalculator.calculate(taxDeclaration);

        taxDeclarationRepository.save(taxDeclaration);
        resultRepository.save(result);

        return result;

    }
}
