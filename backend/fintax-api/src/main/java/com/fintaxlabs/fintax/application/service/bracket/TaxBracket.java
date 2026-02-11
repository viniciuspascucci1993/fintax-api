package com.fintaxlabs.fintax.application.service.bracket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxBracket {

    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal rate;

    public boolean matches(BigDecimal value) {
        boolean greaterOrEqualMin = value.compareTo(min) >= 0;
        boolean lessThanMax = max == null || value.compareTo(max) < 0;
        return greaterOrEqualMin && lessThanMax;
    }
}
