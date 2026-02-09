package com.fintaxlabs.fintax.infrastructure.config;

import com.fintaxlabs.fintax.adapter.output.persistence.InMemoryTaxDeclarationRepository;
import com.fintaxlabs.fintax.adapter.output.persistence.InMemoryTaxResultRepository;
import com.fintaxlabs.fintax.application.port.output.TaxDeclarationRepository;
import com.fintaxlabs.fintax.application.port.output.TaxResultRepository;
import com.fintaxlabs.fintax.application.usecase.SimulateTaxUseCase;
import com.fintaxlabs.fintax.domain.service.TaxCalculator;
import com.fintaxlabs.fintax.application.service.TaxCalculator2026;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public TaxCalculator taxCalculatorService() {
        return new TaxCalculator2026();
    }

    @Bean
    public TaxDeclarationRepository taxDeclarationRepository() {
        return new InMemoryTaxDeclarationRepository();
    }

    @Bean
    public TaxResultRepository taxResultRepository() {
        return new InMemoryTaxResultRepository();
    }

    @Bean
    public SimulateTaxUseCase simulateTaxUseCase(TaxCalculator taxCalculator,
                         TaxDeclarationRepository taxDeclarationRepository,
                                                 TaxResultRepository taxResultRepository) {
        return new SimulateTaxUseCase(taxCalculator, taxDeclarationRepository, taxResultRepository);
    }
}
