package com.fintaxlabs.fintax.adapter.input.web.dto.response;

import com.fintaxlabs.fintax.adapter.input.web.dto.request.TaxpayerRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxAssessmentResponseDTO {

    private int fiscalYear;
    private TaxpayerResponseDTO taxpayer;
    private TaxAssessmentSummaryDTO summary;
    private List<String> messages;
}
