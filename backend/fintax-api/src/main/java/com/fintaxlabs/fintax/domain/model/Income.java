package com.fintaxlabs.fintax.domain.model;

import com.fintaxlabs.fintax.domain.enums.IncomeType;

import java.math.BigDecimal;

public class Income {

    private BigDecimal amount;
    private BigDecimal taxWithheld;   // IR mensal retido
    private IncomeType type;

    public Income(BigDecimal amount, BigDecimal taxWithheld, IncomeType type) {
        this.amount = amount;
        this.taxWithheld = taxWithheld;
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTaxWithheld() {
        return taxWithheld;
    }

    public void setTaxWithheld(BigDecimal taxWithheld) {
        this.taxWithheld = taxWithheld;
    }

    public IncomeType getType() {
        return type;
    }

    public void setType(IncomeType type) {
        this.type = type;
    }
}
