package com.fintaxlabs.fintax.adapter.output.persistence.repository;

import com.fintaxlabs.fintax.adapter.output.persistence.entiity.TaxDeclarationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaTaxDeclarationRepository extends JpaRepository<TaxDeclarationEntity, UUID> {
}
