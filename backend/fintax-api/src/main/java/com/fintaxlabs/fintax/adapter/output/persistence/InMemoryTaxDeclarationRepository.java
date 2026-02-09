package com.fintaxlabs.fintax.adapter.output.persistence;

import com.fintaxlabs.fintax.application.port.output.TaxDeclarationRepository;
import com.fintaxlabs.fintax.domain.model.TaxDeclaration;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTaxDeclarationRepository implements TaxDeclarationRepository {

    private final List<TaxDeclaration> storage = new ArrayList<>();

    @Override
    public void save(TaxDeclaration taxDeclaration) {
        storage.add(taxDeclaration);
    }
}
