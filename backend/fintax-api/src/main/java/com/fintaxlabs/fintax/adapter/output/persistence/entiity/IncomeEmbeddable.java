package com.fintaxlabs.fintax.adapter.output.persistence.entiity;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public class IncomeEmbeddable {

    private BigDecimal amount;
    private String type;

    public IncomeEmbeddable() {
    }

    public IncomeEmbeddable(BigDecimal amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
