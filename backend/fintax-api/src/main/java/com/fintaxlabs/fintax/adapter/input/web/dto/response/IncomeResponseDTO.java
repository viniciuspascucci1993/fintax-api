package com.fintaxlabs.fintax.adapter.input.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeResponseDTO {
    private String type;
    private String amount;
}
