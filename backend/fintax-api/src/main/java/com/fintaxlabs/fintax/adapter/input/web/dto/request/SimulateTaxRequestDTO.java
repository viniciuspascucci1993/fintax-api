package com.fintaxlabs.fintax.adapter.input.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimulateTaxRequestDTO {

    private Integer fiscalYear;
    private String regime;
    private TaxpayerRequestDTO taxpayer;
    private List<IncomeRequestDTO> incomes;
    private List<DeductionRequestDTO> deductions;
}
