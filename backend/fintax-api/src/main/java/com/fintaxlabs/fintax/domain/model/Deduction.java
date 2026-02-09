package com.fintaxlabs.fintax.domain.model;

import com.fintaxlabs.fintax.domain.enums.DeductionType;

import java.math.BigDecimal;

public class Deduction {
    private BigDecimal amount;
    private DeductionType type;

    public Deduction(BigDecimal amount, DeductionType type) {
        this.amount = amount;
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public DeductionType getTypeDeduction() {
        return type;
    }

    public void setTypeDeduction(DeductionType type) {
        this.type = type;
    }
}
