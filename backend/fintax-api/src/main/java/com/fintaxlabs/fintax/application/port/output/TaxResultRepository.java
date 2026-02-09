package com.fintaxlabs.fintax.application.port.output;

import com.fintaxlabs.fintax.domain.model.TaxDeclaration;
import com.fintaxlabs.fintax.domain.model.TaxResult;

import java.util.Optional;
import java.util.UUID;

public interface TaxResultRepository {

    void save(TaxResult result);
    Optional<TaxResult> findById(UUID id);
}
