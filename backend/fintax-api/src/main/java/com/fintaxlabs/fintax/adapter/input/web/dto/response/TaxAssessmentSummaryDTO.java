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

    private BigDecimal totalTaxWithheld;
    private BigDecimal amountToPay;
    private BigDecimal refund;
    private BigDecimal monthlyTaxDue;

    private boolean darfRequired;
    private BigDecimal installmentValue;

    private TaxAssessmentStatus status;
}
