package com.fintaxlabs.fintax.domain.model;

import com.fintaxlabs.fintax.domain.enums.TaxRegime;

import java.util.List;

public class TaxDeclaration {

    private Integer fiscalYear;
    private Taxpayer taxPayer;
    private List<Income> incomes;
    private List<Deduction> deductions;
    private TaxRegime regime;

    public TaxDeclaration(Integer fiscalYear,
                          Taxpayer taxPayer,
                          List<Income> incomes,
                          List<Deduction> deductions,
                          TaxRegime regime) {
        this.fiscalYear = fiscalYear;
        this.taxPayer = taxPayer;
        this.incomes = incomes;
        this.deductions = deductions;
        this.regime = regime;
    }

    public Integer getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(Integer fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public Taxpayer getTaxPayer() {
        return taxPayer;
    }

    public void setTaxPayer(Taxpayer taxPayer) {
        this.taxPayer = taxPayer;
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
