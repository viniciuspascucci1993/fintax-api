package com.fintaxlabs.fintax.domain.model;

import com.fintaxlabs.fintax.domain.enums.TaxRegime;

import java.math.BigDecimal;
import java.util.Map;

public class TaxComparisonResult {

    private TaxRegime bestRegime;
    private BigDecimal economy;
    private Map<TaxRegime, TaxResult> results;

    public TaxComparisonResult() { }

    public TaxComparisonResult(TaxRegime bestRegime, BigDecimal economy, Map<TaxRegime, TaxResult> results) {
        this.bestRegime = bestRegime;
        this.economy = economy;
        this.results = results;
    }

    public TaxRegime getBestRegime() {
        return bestRegime;
    }

    public void setBestRegime(TaxRegime bestRegime) {
        this.bestRegime = bestRegime;
    }

    public BigDecimal getEconomy() {
        return economy;
    }

    public void setEconomy(BigDecimal economy) {
        this.economy = economy;
    }

    public Map<TaxRegime, TaxResult> getResults() {
        return results;
    }

    public void setResults(Map<TaxRegime, TaxResult> results) {
        this.results = results;
    }
}
