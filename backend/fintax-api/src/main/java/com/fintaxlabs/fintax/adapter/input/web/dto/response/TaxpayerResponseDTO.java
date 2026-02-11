package com.fintaxlabs.fintax.adapter.input.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxpayerResponseDTO {

    private String fullName;
    private String taxId;
    private LocalDate birthDate;
    private boolean hasDependents;
}
