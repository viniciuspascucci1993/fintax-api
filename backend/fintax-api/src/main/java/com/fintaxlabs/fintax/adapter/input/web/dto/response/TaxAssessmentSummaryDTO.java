package com.fintaxlabs.fintax.adapter.input.web.dto.response;

import com.fintaxlabs.fintax.domain.enums.TaxAssessmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxAssessmentSummaryDTO {

    private BigDecimal annualIncome;
    private BigDecimal annualDeductions;
    private BigDecimal taxableBase;
    private BigDecimal taxDue;
    private TaxAssessmentStatus status;
}
