package com.fintaxlabs.fintax.adapter.output.persistence;

import com.fintaxlabs.fintax.adapter.output.persistence.entiity.TaxDeclarationEntity;
import com.fintaxlabs.fintax.adapter.output.persistence.mapper.TaxDeclarationEntityMapper;
import com.fintaxlabs.fintax.adapter.output.persistence.repository.JpaTaxDeclarationRepository;
import com.fintaxlabs.fintax.application.port.output.TaxDeclarationRepository;
import com.fintaxlabs.fintax.domain.model.TaxDeclaration;

import java.util.Optional;
import java.util.UUID;

public class TaxDeclarationRepositoryAdapter implements TaxDeclarationRepository {

    private final JpaTaxDeclarationRepository jpaRepository;
    private final TaxDeclarationEntityMapper mapper;

    public TaxDeclarationRepositoryAdapter(JpaTaxDeclarationRepository jpaRepository,
                       TaxDeclarationEntityMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(TaxDeclaration taxDeclaration) {
        TaxDeclarationEntity entity =
                mapper.toEntity(taxDeclaration);
        jpaRepository.save(entity);

    }

    @Override
    public Optional<TaxDeclaration> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }
}
