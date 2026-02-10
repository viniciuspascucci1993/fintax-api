package com.fintaxlabs.fintax.adapter.input.web.controller;

import com.fintaxlabs.fintax.adapter.input.web.dto.request.CompareTaxRequestDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.request.SimulateTaxRequestDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.response.TaxComparisonResponseDTO;
import com.fintaxlabs.fintax.adapter.input.web.mapper.TaxComparisonMapper;
import com.fintaxlabs.fintax.adapter.input.web.mapper.TaxSimulationMapper;
import com.fintaxlabs.fintax.application.service.TaxDisclaimerService;
import com.fintaxlabs.fintax.application.usecase.CompareTaxRegimesUseCase;
import com.fintaxlabs.fintax.domain.model.TaxComparisonResult;
import com.fintaxlabs.fintax.domain.model.TaxDeclaration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tax")
public class TaxComparisonController {

    private final CompareTaxRegimesUseCase compareTaxRegimesUseCase;
    private final TaxDisclaimerService taxDisclaimerService;

    public TaxComparisonController(CompareTaxRegimesUseCase compareTaxRegimesUseCase,
                                   TaxDisclaimerService taxDisclaimerService) {
        this.compareTaxRegimesUseCase = compareTaxRegimesUseCase;
        this.taxDisclaimerService = taxDisclaimerService;
    }

    @PostMapping("/compare")
    public ResponseEntity<TaxComparisonResponseDTO> compare(
            @RequestBody CompareTaxRequestDTO request
    ) {
        TaxDeclaration declaration = TaxSimulationMapper.toDomainForComparison(request);

        TaxComparisonResult result = compareTaxRegimesUseCase.execute(declaration);
        return ResponseEntity.ok(
                TaxComparisonMapper.toResponse(result, taxDisclaimerService)
        );
    }
}
