package com.fintaxlabs.fintax.infrastructure.config;

import com.fintaxlabs.fintax.adapter.output.persistence.memory.InMemoryTaxDeclarationRepository;
import com.fintaxlabs.fintax.adapter.output.persistence.memory.InMemoryTaxResultRepository;
import com.fintaxlabs.fintax.application.port.output.TaxDeclarationRepository;
import com.fintaxlabs.fintax.application.port.output.TaxResultRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"local"})
public class InMemoryPersistenceConfig {

    @Bean
    public TaxDeclarationRepository taxDeclarationRepository() {
        return new InMemoryTaxDeclarationRepository();
    }

    @Bean
    public TaxResultRepository taxResultRepository() {
        return new InMemoryTaxResultRepository();
    }
}
