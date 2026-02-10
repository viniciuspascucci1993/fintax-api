package com.fintaxlabs.fintax.infrastructure.config;

import com.fintaxlabs.fintax.application.port.output.TaxDeclarationRepository;
import com.fintaxlabs.fintax.application.port.output.TaxResultRepository;
import com.fintaxlabs.fintax.application.resolver.TaxCalculatorFactory;
import com.fintaxlabs.fintax.application.service.CompleteTaxCalculator;
import com.fintaxlabs.fintax.application.service.SimplifiedTaxCalculator;
import com.fintaxlabs.fintax.application.service.TaxDisclaimerService;
import com.fintaxlabs.fintax.application.usecase.CompareTaxRegimesUseCase;
import com.fintaxlabs.fintax.application.usecase.FindTaxDeclarationByIdUseCase;
import com.fintaxlabs.fintax.application.usecase.SimulateTaxUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationBeanConfig {

    @Bean
    public SimplifiedTaxCalculator simplifiedTaxCalculator() {
        return new SimplifiedTaxCalculator();
    }

    @Bean
    public CompleteTaxCalculator completeTaxCalculator() {
        return new CompleteTaxCalculator();
    }

    @Bean
    public TaxDisclaimerService taxDisclaimerService() {
        return new TaxDisclaimerService();
    }

    @Bean
    public SimulateTaxUseCase simulateTaxUseCase(
            TaxCalculatorFactory factory,
            TaxDeclarationRepository taxDeclarationRepository,
            TaxResultRepository taxResultRepository
    ) {
        return new SimulateTaxUseCase(
                factory,
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

    @Bean
    public TaxCalculatorFactory taxCalculatorFactory(
            SimplifiedTaxCalculator simplified,
            CompleteTaxCalculator complete
    ) {
        return new TaxCalculatorFactory(simplified, complete);
    }

    @Bean
    public CompareTaxRegimesUseCase compareTaxRegimesUseCase(
            TaxCalculatorFactory factory
    ) {
        return new CompareTaxRegimesUseCase(factory);
    }
}
