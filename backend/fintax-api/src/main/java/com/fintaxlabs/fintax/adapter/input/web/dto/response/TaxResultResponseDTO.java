package com.fintaxlabs.fintax.adapter.input.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxResultResponseDTO {

    private UUID taxDeclarationId;
    private String regime;
    private BigDecimal grossIncome;
    private BigDecimal totalDeductions;
    private BigDecimal taxableBase;
    private BigDecimal taxDue;
    private BigDecimal refund;
}
