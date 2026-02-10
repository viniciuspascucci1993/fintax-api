package com.fintaxlabs.fintax.application.usecase;

import com.fintaxlabs.fintax.application.port.output.TaxDeclarationRepository;
import com.fintaxlabs.fintax.application.port.output.TaxResultRepository;
import com.fintaxlabs.fintax.application.resolver.TaxCalculatorFactory;
import com.fintaxlabs.fintax.domain.model.TaxDeclaration;
import com.fintaxlabs.fintax.domain.model.TaxResult;
import com.fintaxlabs.fintax.domain.service.TaxCalculator;

import java.util.UUID;

public class SimulateTaxUseCase {

    private final TaxCalculatorFactory factory;
    private final TaxDeclarationRepository taxDeclarationRepository;
    private final TaxResultRepository resultRepository;

    public SimulateTaxUseCase(TaxCalculatorFactory factory,
                              TaxDeclarationRepository taxDeclarationRepository,
                              TaxResultRepository resultRepository) {
        this.factory = factory;
        this.taxDeclarationRepository = taxDeclarationRepository;
        this.resultRepository = resultRepository;
    }

    public TaxResult execute(TaxDeclaration taxDeclaration) {

        if (taxDeclaration.getId() == null) {
            taxDeclaration.setId(UUID.randomUUID());
        }

        if (taxDeclaration.getTaxPayer().getId() == null) {
            taxDeclaration.getTaxPayer().setId(UUID.randomUUID());
        }

        TaxCalculator calculator =
                factory.resolve(taxDeclaration.getRegime());

        TaxResult result = calculator.calculate(taxDeclaration);

        taxDeclarationRepository.save(taxDeclaration);
        resultRepository.save(result);

        return result;

    }
}
