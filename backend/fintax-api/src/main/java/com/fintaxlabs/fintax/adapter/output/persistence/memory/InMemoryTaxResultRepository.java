package com.fintaxlabs.fintax.adapter.output.persistence.memory;

import com.fintaxlabs.fintax.application.port.output.TaxResultRepository;
import com.fintaxlabs.fintax.domain.model.TaxDeclaration;
import com.fintaxlabs.fintax.domain.model.TaxResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InMemoryTaxResultRepository implements TaxResultRepository {

    private final List<TaxResult> storage = new ArrayList<>();

    @Override
    public void save(TaxResult result) {
        storage.add(result);
    }

    @Override
    public Optional<TaxResult> findById(UUID id) {
        return storage.stream()
                .filter(result -> id.equals(result.getTaxDeclarationId()))
                .findFirst();
    }
}
