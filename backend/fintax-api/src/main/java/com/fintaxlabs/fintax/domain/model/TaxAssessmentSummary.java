package com.fintaxlabs.fintax.domain.model;

import com.fintaxlabs.fintax.domain.enums.TaxAssessmentStatus;

import java.math.BigDecimal;

public class TaxAssessmentSummary {

    private BigDecimal annualIncome;
    private BigDecimal annualDeductions;
    private BigDecimal taxableBase;
    private BigDecimal taxDue;
    private TaxAssessmentStatus status;

    public TaxAssessmentSummary() { }

    public TaxAssessmentSummary(BigDecimal annualIncome, BigDecimal annualDeductions, BigDecimal taxableBase, BigDecimal taxDue, TaxAssessmentStatus status) {
        this.annualIncome = annualIncome;
        this.annualDeductions = annualDeductions;
        this.taxableBase = taxableBase;
        this.taxDue = taxDue;
        this.status = status;
    }

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(BigDecimal annualIncome) {
        this.annualIncome = annualIncome;
    }

    public BigDecimal getAnnualDeductions() {
        return annualDeductions;
    }

    public void setAnnualDeductions(BigDecimal annualDeductions) {
        this.annualDeductions = annualDeductions;
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

    public TaxAssessmentStatus getStatus() {
        return status;
    }

    public void setStatus(TaxAssessmentStatus status) {
        this.status = status;
    }
}
