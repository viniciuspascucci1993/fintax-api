package com.fintaxlabs.fintax.adapter.output.persistence.entiity;

import com.fintaxlabs.fintax.domain.enums.IncomeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

@Embeddable
public class IncomeEmbeddable {

    private BigDecimal amount;
    private BigDecimal taxWithheld;

    @Enumerated(EnumType.STRING)
    private IncomeType type;

    public IncomeEmbeddable() {
    }

    public IncomeEmbeddable(BigDecimal amount, BigDecimal taxWithheld, IncomeType type) {
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
