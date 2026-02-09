package com.fintaxlabs.fintax.adapter.input.web.controller;

import com.fintaxlabs.fintax.adapter.input.web.dto.request.SimulateTaxRequestDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.response.TaxDeclarationResponseDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.response.TaxResultResponseDTO;
import com.fintaxlabs.fintax.adapter.input.web.mapper.TaxDeclarationWebMapper;
import com.fintaxlabs.fintax.adapter.input.web.mapper.TaxSimulationMapper;
import com.fintaxlabs.fintax.application.usecase.FindTaxDeclarationByIdUseCase;
import com.fintaxlabs.fintax.application.usecase.SimulateTaxUseCase;
import com.fintaxlabs.fintax.domain.model.TaxDeclaration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tax")
public class TaxSimulationController {

    private final SimulateTaxUseCase simulateTaxUseCase;
    private final FindTaxDeclarationByIdUseCase findByIdUseCase;

    public TaxSimulationController(SimulateTaxUseCase simulateTaxUseCase, FindTaxDeclarationByIdUseCase findByIdUseCase) {
        this.simulateTaxUseCase = simulateTaxUseCase;
        this.findByIdUseCase = findByIdUseCase;
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

    @GetMapping("/{id}")
    public ResponseEntity<TaxDeclarationResponseDTO> findById(
            @PathVariable("id") UUID id
    ) {
        return ResponseEntity.ok(
                TaxDeclarationWebMapper.toResponse(
                        findByIdUseCase.execute(id)
                )
        );
    }
}
