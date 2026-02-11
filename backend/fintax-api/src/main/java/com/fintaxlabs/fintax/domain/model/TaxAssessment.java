package com.fintaxlabs.fintax.domain.model;

import java.util.List;

public class TaxAssessment {

    private int fiscalYear;
    private Taxpayer taxpayer;

    private TaxAssessmentSummary summary;
    private List<String> messages;

    public TaxAssessment() { }

    public TaxAssessment(int fiscalYear, Taxpayer taxpayer, TaxAssessmentSummary summary, List<String> messages) {
        this.fiscalYear = fiscalYear;
        this.taxpayer = taxpayer;
        this.summary = summary;
        this.messages = messages;
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

    public TaxAssessmentSummary getSummary() {
        return summary;
    }

    public void setSummary(TaxAssessmentSummary summary) {
        this.summary = summary;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
