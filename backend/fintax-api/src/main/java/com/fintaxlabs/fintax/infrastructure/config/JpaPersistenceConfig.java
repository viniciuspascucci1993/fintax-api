package com.fintaxlabs.fintax.infrastructure.config;

import com.fintaxlabs.fintax.adapter.output.persistence.TaxDeclarationRepositoryAdapter;
import com.fintaxlabs.fintax.adapter.output.persistence.TaxResultRepositoryAdapter;
import com.fintaxlabs.fintax.adapter.output.persistence.mapper.TaxDeclarationEntityMapper;
import com.fintaxlabs.fintax.adapter.output.persistence.mapper.TaxResultEntityMapper;
import com.fintaxlabs.fintax.adapter.output.persistence.repository.JpaTaxDeclarationRepository;
import com.fintaxlabs.fintax.adapter.output.persistence.repository.JpaTaxResultRepository;
import com.fintaxlabs.fintax.application.port.output.TaxDeclarationRepository;
import com.fintaxlabs.fintax.application.port.output.TaxResultRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class JpaPersistenceConfig {

    @Bean
    public TaxDeclarationEntityMapper taxDeclarationEntityMapper() {
        return new TaxDeclarationEntityMapper();
    }

    @Bean
    public TaxResultEntityMapper taxResultEntityMapper() {
        return new TaxResultEntityMapper();
    }

    @Bean
    public TaxDeclarationRepository taxDeclarationRepository(
            JpaTaxDeclarationRepository jpaRepository,
            TaxDeclarationEntityMapper mapper
    ) {
        return new TaxDeclarationRepositoryAdapter(jpaRepository, mapper);
    }

    @Bean
    public TaxResultRepository taxResultRepository(
            JpaTaxResultRepository jpaRepository,
            TaxResultEntityMapper mapper
    ) {
        return new TaxResultRepositoryAdapter(jpaRepository, mapper);
    }

}
