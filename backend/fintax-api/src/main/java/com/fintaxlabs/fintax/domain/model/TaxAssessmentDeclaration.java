package com.fintaxlabs.fintax.domain.model;

import com.fintaxlabs.fintax.domain.enums.TaxRegime;

import java.util.List;

public class TaxAssessmentDeclaration {

    private int fiscalYear;
    private Taxpayer taxpayer;
    private List<Income> incomes;
    private List<Deduction> deductions;
    private TaxRegime regime;

    public TaxAssessmentDeclaration() { }

    public TaxAssessmentDeclaration(int fiscalYear, Taxpayer taxpayer, List<Income> incomes,
                                    List<Deduction> deductions, TaxRegime regime) {
        this.fiscalYear = fiscalYear;
        this.taxpayer = taxpayer;
        this.incomes = incomes;
        this.deductions = deductions;
        this.regime = regime;
    }

    public int getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(int fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public Taxpayer getTaxpayer() {
        return taxpayer;
    }

    public void setTaxpayer(Taxpayer taxpayer) {
        this.taxpayer = taxpayer;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }

    public List<Deduction> getDeductions() {
        return deductions;
    }

    public void setDeductions(List<Deduction> deductions) {
        this.deductions = deductions;
    }

    public TaxRegime getRegime() {
        return regime;
    }

    public void setRegime(TaxRegime regime) {
        this.regime = regime;
    }
}
