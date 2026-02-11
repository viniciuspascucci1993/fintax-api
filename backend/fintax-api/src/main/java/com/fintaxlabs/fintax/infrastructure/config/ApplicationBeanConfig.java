package com.fintaxlabs.fintax.infrastructure.config;

import com.fintaxlabs.fintax.application.port.output.TaxDeclarationRepository;
import com.fintaxlabs.fintax.application.port.output.TaxResultRepository;
import com.fintaxlabs.fintax.application.resolver.TaxCalculatorFactory;
import com.fintaxlabs.fintax.application.service.TaxTable2026CompleteService;
import com.fintaxlabs.fintax.application.service.TaxTable2026SimplifiedService;
import com.fintaxlabs.fintax.application.service.TaxDisclaimerService;
import com.fintaxlabs.fintax.application.usecase.CompareTaxRegimesUseCase;
import com.fintaxlabs.fintax.application.usecase.FindTaxDeclarationByIdUseCase;
import com.fintaxlabs.fintax.application.usecase.SimulateTaxUseCase;
import com.fintaxlabs.fintax.application.usecase.TaxIrPfAssessmentUseCase;
import com.fintaxlabs.fintax.domain.model.factory.TaxTableFactory;
import com.fintaxlabs.fintax.domain.model.factory.impl.TaxTableFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfig {

    @Bean
    public TaxTable2026SimplifiedService simplifiedTaxCalculator() {
        return new TaxTable2026SimplifiedService();
    }

    @Bean
    public TaxTable2026CompleteService completeTaxCalculator() {
        return new TaxTable2026CompleteService();
    }

    @Bean
    public TaxDisclaimerService taxDisclaimerService() {
        return new TaxDisclaimerService();
    }

    @Bean
    public TaxTableFactory taxTableFactory(
    ) {
        return new TaxTableFactoryImpl();
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
            TaxTable2026SimplifiedService simplified,
            TaxTable2026CompleteService complete
    ) {
        return new TaxCalculatorFactory(simplified, complete);
    }

    @Bean
    public CompareTaxRegimesUseCase compareTaxRegimesUseCase(
            TaxCalculatorFactory factory
    ) {
        return new CompareTaxRegimesUseCase(factory);
    }

    @Bean
    public TaxIrPfAssessmentUseCase taxIrPfAssessmentUseCase(TaxTableFactory taxTableFactory) {
        return new TaxIrPfAssessmentUseCase(taxTableFactory);
    }
}
