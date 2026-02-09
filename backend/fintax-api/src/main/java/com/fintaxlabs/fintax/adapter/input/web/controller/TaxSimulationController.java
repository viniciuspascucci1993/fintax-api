package com.fintaxlabs.fintax.adapter.input.web.controller;

import com.fintaxlabs.fintax.adapter.input.web.dto.request.SimulateTaxRequestDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.response.TaxResultResponseDTO;
import com.fintaxlabs.fintax.adapter.input.web.mapper.TaxSimulationMapper;
import com.fintaxlabs.fintax.application.usecase.SimulateTaxUseCase;
import com.fintaxlabs.fintax.domain.model.TaxDeclaration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tax")
public class TaxSimulationController {

    private final SimulateTaxUseCase simulateTaxUseCase;

    public TaxSimulationController(SimulateTaxUseCase simulateTaxUseCase) {
        this.simulateTaxUseCase = simulateTaxUseCase;
    }

    public ResponseEntity<TaxResultResponseDTO> simulate(
            @RequestBody SimulateTaxRequestDTO request
    ) {
        TaxDeclaration declaration = TaxSimulationMapper.toDomain(request);

        TaxResultResponseDTO response =
                TaxSimulationMapper.toResponse(
                        simulateTaxUseCase.execute(declaration)
                );

        return ResponseEntity.ok(response);
    }
}
