package com.fintaxlabs.fintax.adapter.input.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeRequestDTO {

    private BigDecimal amount;
    private String type;
}
