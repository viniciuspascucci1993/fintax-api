package com.fintaxlabs.fintax.infrastructure.config;

import com.fintaxlabs.fintax.application.port.output.TaxDeclarationRepository;
import com.fintaxlabs.fintax.application.port.output.TaxResultRepository;
import com.fintaxlabs.fintax.application.service.TaxCalculator2026;
import com.fintaxlabs.fintax.application.usecase.FindTaxDeclarationByIdUseCase;
import com.fintaxlabs.fintax.application.usecase.SimulateTaxUseCase;
import com.fintaxlabs.fintax.domain.service.TaxCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfig {

    @Bean
    public TaxCalculator taxCalculator() {
        return new TaxCalculator2026();
    }

    @Bean
    public SimulateTaxUseCase simulateTaxUseCase(
            TaxCalculator taxCalculator,
            TaxDeclarationRepository taxDeclarationRepository,
            TaxResultRepository taxResultRepository
    ) {
        return new SimulateTaxUseCase(
                taxCalculator,
                taxDeclarationRepository,
                taxResultRepository
        );
    }

    @Bean
    public FindTaxDeclarationByIdUseCase findTaxDeclarationByIdUseCase(
            TaxDeclarationRepository repository
    ) {
        return new FindTaxDeclarationByIdUseCase(repository);
    }
}
