package com.fintaxlabs.fintax.adapter.input.web.controller;

import com.fintaxlabs.fintax.adapter.input.web.dto.request.TaxAssessmentRequestDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.response.TaxAssessmentResponseDTO;
import com.fintaxlabs.fintax.adapter.input.web.mapper.TaxAssessmentDeclarationMapper;
import com.fintaxlabs.fintax.adapter.input.web.mapper.TaxAssessmentResponseMapper;
import com.fintaxlabs.fintax.application.usecase.TaxIrPfAssessmentUseCase;
import com.fintaxlabs.fintax.domain.model.TaxAssessment;
import com.fintaxlabs.fintax.domain.model.TaxAssessmentDeclaration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/irpf/assessment")
public class IrPfAssessmentController {

    private final TaxIrPfAssessmentUseCase taxIrPfAssessmentUseCase;

    public IrPfAssessmentController(TaxIrPfAssessmentUseCase taxIrPfAssessmentUseCase) {
        this.taxIrPfAssessmentUseCase = taxIrPfAssessmentUseCase;
    }

    @PostMapping
    public ResponseEntity<TaxAssessmentResponseDTO> assess(
            @RequestBody TaxAssessmentRequestDTO request
    ) {

        // 1 - Request -> Domínio
        TaxAssessmentDeclaration declaration =
                TaxAssessmentDeclarationMapper.toDomain(request);

        // 2 - Executa regra
        TaxAssessment assessment =
                taxIrPfAssessmentUseCase.execute(declaration);

        // 3 - Domínio -> Response
        TaxAssessmentResponseDTO response =
                TaxAssessmentResponseMapper.fromDomain(assessment);

        return ResponseEntity.ok(response);
    }
}
