package com.fintaxlabs.fintax.adapter.output.persistence.entiity;

import com.fintaxlabs.fintax.domain.enums.DeductionType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

@Embeddable
public class DeductionEmbeddable {

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private DeductionType type;

    public DeductionEmbeddable() {
    }

    public DeductionEmbeddable(BigDecimal amount, DeductionType type) {
        this.amount = amount;
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public DeductionType getType() {
        return type;
    }

    public void setType(DeductionType type) {
        this.type = type;
    }
}
