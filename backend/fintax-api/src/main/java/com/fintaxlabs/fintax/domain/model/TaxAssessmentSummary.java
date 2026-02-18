package com.fintaxlabs.fintax.domain.model;

import com.fintaxlabs.fintax.domain.enums.TaxAssessmentStatus;

import java.math.BigDecimal;

public class TaxAssessmentSummary {

    private BigDecimal annualIncome;
    private BigDecimal annualDeductions;
    private BigDecimal taxableBase;
    private BigDecimal taxDue;
    private BigDecimal totalTaxWithheld;
    private BigDecimal amountToPay;
    private BigDecimal refund;
    private BigDecimal monthlyTaxDue;
    private boolean darfRequired;
    private BigDecimal installmentValue;
    private TaxAssessmentStatus status;

    public TaxAssessmentSummary() { }

    public TaxAssessmentSummary(BigDecimal annualIncome, BigDecimal annualDeductions, BigDecimal taxableBase,
                                BigDecimal taxDue, BigDecimal totalTaxWithheld,
                                BigDecimal amountToPay, BigDecimal refund, BigDecimal monthlyTaxDue,
                                boolean darfRequired, BigDecimal installmentValue, TaxAssessmentStatus status) {
        this.annualIncome = annualIncome;
        this.annualDeductions = annualDeductions;
        this.taxableBase = taxableBase;
        this.taxDue = taxDue;
        this.totalTaxWithheld = totalTaxWithheld;
        this.amountToPay = amountToPay;
        this.refund = refund;
        this.monthlyTaxDue = monthlyTaxDue;
        this.darfRequired = darfRequired;
        this.installmentValue = installmentValue;
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

    public BigDecimal getTotalTaxWithheld() {
        return totalTaxWithheld;
    }

    public void setTotalTaxWithheld(BigDecimal totalTaxWithheld) {
        this.totalTaxWithheld = totalTaxWithheld;
    }

    public BigDecimal getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(BigDecimal amountToPay) {
        this.amountToPay = amountToPay;
    }

    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
    }

    public BigDecimal getMonthlyTaxDue() {
        return monthlyTaxDue;
    }

    public void setMonthlyTaxDue(BigDecimal monthlyTaxDue) {
        this.monthlyTaxDue = monthlyTaxDue;
    }

    public boolean isDarfRequired() {
        return darfRequired;
    }

    public void setDarfRequired(boolean darfRequired) {
        this.darfRequired = darfRequired;
    }

    public BigDecimal getInstallmentValue() {
        return installmentValue;
    }

    public void setInstallmentValue(BigDecimal installmentValue) {
        this.installmentValue = installmentValue;
    }

    public TaxAssessmentStatus getStatus() {
        return status;
    }

    public void setStatus(TaxAssessmentStatus status) {
        this.status = status;
    }
}
