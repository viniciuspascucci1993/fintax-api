package com.fintaxlabs.fintax.adapter.output.persistence;

import com.fintaxlabs.fintax.application.port.output.TaxDeclarationRepository;
import com.fintaxlabs.fintax.domain.model.TaxDeclaration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InMemoryTaxDeclarationRepository implements TaxDeclarationRepository {

    private final List<TaxDeclaration> storage = new ArrayList<>();

    @Override
    public void save(TaxDeclaration taxDeclaration) {
        storage.add(taxDeclaration);
    }

    @Override
    public Optional<TaxDeclaration> findById(UUID id) {
        return storage.stream()
                .filter(result -> id.equals(result.getId()))
                .findFirst();
    }
}
