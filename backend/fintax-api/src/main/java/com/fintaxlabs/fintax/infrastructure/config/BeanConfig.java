package com.fintaxlabs.fintax.infrastructure.config;

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
    public SimulateTaxUseCase simulateTaxUseCase(TaxCalculator taxCalculator) {
        return new SimulateTaxUseCase(taxCalculator);
    }
}
