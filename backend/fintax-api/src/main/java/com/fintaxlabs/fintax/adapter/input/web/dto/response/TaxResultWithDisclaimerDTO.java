package com.fintaxlabs.fintax.adapter.input.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxResultWithDisclaimerDTO {

    private UUID taxDeclarationId;
    private String regime;
    private BigDecimal grossIncome;
    private BigDecimal totalDeductions;
    private BigDecimal taxableBase;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal taxDue;
    private BigDecimal refund;
    private String disclaimer;
}
