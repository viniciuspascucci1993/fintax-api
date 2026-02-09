package com.fintaxlabs.fintax.infrastructure.config;

import com.fintaxlabs.fintax.adapter.TaxDeclarationRepositoryAdapter;
import com.fintaxlabs.fintax.adapter.output.persistence.mapper.TaxDeclarationEntityMapper;
import com.fintaxlabs.fintax.adapter.output.persistence.repository.JpaTaxDeclarationRepository;
import com.fintaxlabs.fintax.application.port.output.TaxDeclarationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceBeanConfig {

    @Bean
    public TaxDeclarationEntityMapper taxDeclarationEntityMapper() {
        return new TaxDeclarationEntityMapper();
    }

    @Bean
    public TaxDeclarationRepository taxDeclarationRepository(
            JpaTaxDeclarationRepository jpaRepository,
            TaxDeclarationEntityMapper mapper
    ) {
        return new TaxDeclarationRepositoryAdapter(jpaRepository, mapper);
    }
}
