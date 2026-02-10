package com.fintaxlabs.fintax.application.service;

import com.fintaxlabs.fintax.domain.enums.TaxRegime;
import com.fintaxlabs.fintax.domain.model.TaxComparisonResult;

public class TaxDisclaimerService {

    public String generate(TaxComparisonResult result) {

        if (result.getEconomy().signum() == 0) {
            return "Both tax regimes result in the same tax amount. The simplified regime may be chosen for convenience.";
        }

        if (result.getBestRegime() == TaxRegime.SIMPLIFIED) {
            return "The simplified regime appears to be more advantageous based on the provided data. However, " +
                    " individual deductions and future income variations may affect this outcome.";
        }

        return "The complete regime appears to be more advantageous due to higher deductible expenses. " +
                " It is recommended to review deductible documentation carefully.";
    }
}
