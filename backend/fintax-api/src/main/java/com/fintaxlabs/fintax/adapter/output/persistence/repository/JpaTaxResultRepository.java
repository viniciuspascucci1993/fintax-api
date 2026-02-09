package com.fintaxlabs.fintax.adapter.output.persistence.repository;

import com.fintaxlabs.fintax.adapter.output.persistence.entiity.TaxResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaTaxResultRepository  extends JpaRepository<TaxResultEntity, UUID> {
}
