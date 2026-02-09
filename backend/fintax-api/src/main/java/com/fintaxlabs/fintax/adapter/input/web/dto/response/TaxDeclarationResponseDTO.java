package com.fintaxlabs.fintax.adapter.input.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxDeclarationResponseDTO {

    private Integer fiscalYear;
    private String regime;
    private TaxpayerResponseDTO taxpayer;
    private List<IncomeResponseDTO> incomes;
    private List<DeductionResponseDTO> deductions;
}
