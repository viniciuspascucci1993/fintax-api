package com.fintaxlabs.fintax.adapter.output.persistence;

import com.fintaxlabs.fintax.adapter.output.persistence.mapper.TaxResultEntityMapper;
import com.fintaxlabs.fintax.adapter.output.persistence.repository.JpaTaxResultRepository;
import com.fintaxlabs.fintax.application.port.output.TaxResultRepository;
import com.fintaxlabs.fintax.domain.model.TaxResult;

import java.util.Optional;
import java.util.UUID;

public class TaxResultRepositoryAdapter implements TaxResultRepository {

    private final JpaTaxResultRepository repository;
    private final TaxResultEntityMapper mapper;

    public TaxResultRepositoryAdapter(JpaTaxResultRepository repository,
                                      TaxResultEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(TaxResult result) {
        repository.save(mapper.toEntity(result));
    }

    @Override
    public Optional<TaxResult> findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }
}
