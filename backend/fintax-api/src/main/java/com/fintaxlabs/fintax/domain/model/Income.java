package com.fintaxlabs.fintax.domain.model;

import com.fintaxlabs.fintax.domain.enums.IncomeType;

import java.math.BigDecimal;

public class Income {

    private BigDecimal amount;
    private IncomeType type;

    public Income(BigDecimal amount, IncomeType type) {
        this.amount = amount;
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public IncomeType getTypeIncome() {
        return type;
    }

    public void setTypeIncome(IncomeType typeIncome) {
        this.type = typeIncome;
    }
}
