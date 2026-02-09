package com.fintaxlabs.fintax.adapter.output.persistence;

import com.fintaxlabs.fintax.application.port.output.TaxResultRepository;
import com.fintaxlabs.fintax.domain.model.TaxResult;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTaxResultRepository implements TaxResultRepository {

    private final List<TaxResult> storage = new ArrayList<>();

    @Override
    public void save(TaxResult result) {
        storage.add(result);
    }
}
