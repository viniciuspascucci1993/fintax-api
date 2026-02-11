package com.fintaxlabs.fintax.adapter.input.web.dto.request;

import com.fintaxlabs.fintax.domain.enums.TaxRegime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxAssessmentRequestDTO {

    private int fiscalYear;
    private TaxRegime regime;
    private TaxpayerRequestDTO taxpayer;
    private List<IncomeRequestDTO> incomes;
    private List<DeductionRequestDTO> deductions;
}
