package com.fintaxlabs.fintax.adapter.input.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxComparisonResponseDTO {

    private String bestRegime;
    private BigDecimal economy;
    private String comparisonSummary;
    private Map<String, TaxResultWithDisclaimerDTO> results;
}
