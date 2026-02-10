package com.fintaxlabs.fintax.application.service;

import com.fintaxlabs.fintax.domain.enums.TaxRegime;

public class TaxDisclaimerService {

    public String forRegime(TaxRegime regime) {
        return switch (regime) {
            case SIMPLIFIED ->
                    "The simplified regime applies a standard deduction rate and may be advantageous when itemized deductions are low.";
            case COMPLETE ->
                    "The complete regime allows full deduction of eligible expenses and may be beneficial when deductible amounts are high.";
        };
    }

    public String comparisonSummary(TaxRegime bestRegime) {
        return switch (bestRegime) {
            case SIMPLIFIED ->
                    "Based on the provided data, the simplified regime results in lower tax liability. This comparison does not account for future income changes or additional deductions.";
            case COMPLETE ->
                    "Based on the provided data, the complete regime results in lower tax liability. This comparison does not account for future income changes or additional deductions.";
        };
    }
}
