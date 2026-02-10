package com.fintaxlabs.fintax.shared.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyUtils {
    private MoneyUtils() {}

    public static BigDecimal scale(BigDecimal value) {
        return value == null
                ? BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP)
                : value.setScale(2, RoundingMode.HALF_UP);
    }
}
