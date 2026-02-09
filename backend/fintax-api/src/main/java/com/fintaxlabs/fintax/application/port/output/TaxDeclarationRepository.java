package com.fintaxlabs.fintax.application.port.output;

import com.fintaxlabs.fintax.domain.model.TaxDeclaration;

import java.util.Optional;
import java.util.UUID;

public interface TaxDeclarationRepository {

    void save(TaxDeclaration taxDeclaration);
    Optional<TaxDeclaration> findById(UUID id);
}
