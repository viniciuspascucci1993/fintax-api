package com.fintaxlabs.fintax.domain.model;

import com.fintaxlabs.fintax.domain.enums.TaxRegime;

import java.math.BigDecimal;
import java.util.UUID;

public class TaxResult {

    private UUID id;
    private TaxRegime taxRegime;
    private BigDecimal grossIncome;
    private BigDecimal totalDeductions;
    private BigDecimal taxableBase;
    private BigDecimal taxDue;
    private BigDecimal refund;

    public TaxResult(
            UUID id,
            TaxRegime taxRegime,
            BigDecimal grossIncome,
            BigDecimal totalDeductions,
            BigDecimal taxableBase,
            BigDecimal taxDue,
            BigDecimal refund) {
        this.id = UUID.randomUUID();
        this.taxRegime = taxRegime;
        this.grossIncome = grossIncome;
        this.totalDeductions = totalDeductions;
        this.taxableBase = taxableBase;
        this.taxDue = taxDue;
        this.refund = refund;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TaxRegime getTaxRegime() {
        return taxRegime;
    }

    public void setTaxRegime(TaxRegime taxRegime) {
        this.taxRegime = taxRegime;
    }

    public BigDecimal getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(BigDecimal grossIncome) {
        this.grossIncome = grossIncome;
    }

    public BigDecimal getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(BigDecimal totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public BigDecimal getTaxableBase() {
        return taxableBase;
    }

    public void setTaxableBase(BigDecimal taxableBase) {
        this.taxableBase = taxableBase;
    }

    public BigDecimal getTaxDue() {
        return taxDue;
    }

    public void setTaxDue(BigDecimal taxDue) {
        this.taxDue = taxDue;
    }

    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
    }
}
