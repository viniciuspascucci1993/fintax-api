package com.fintaxlabs.fintax.application.usecase;

import com.fintaxlabs.fintax.application.port.output.TaxDeclarationRepository;
import com.fintaxlabs.fintax.domain.exception.DomainException;
import com.fintaxlabs.fintax.domain.model.TaxDeclaration;

import java.util.UUID;

public class FindTaxDeclarationByIdUseCase {

    private final TaxDeclarationRepository taxDeclarationRepository;

    public FindTaxDeclarationByIdUseCase(TaxDeclarationRepository taxDeclarationRepository) {
        this.taxDeclarationRepository = taxDeclarationRepository;
    }

    public TaxDeclaration execute(UUID id) {
        return taxDeclarationRepository.findById(id)
                .orElseThrow(() ->
                        new DomainException("Tax declaration not found for id: " + id)
                );
    }
}
