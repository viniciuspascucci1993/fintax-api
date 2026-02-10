package com.fintaxlabs.fintax.adapter.input.web.mapper;

import com.fintaxlabs.fintax.adapter.input.web.dto.response.TaxComparisonResponseDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.response.TaxResultWithDisclaimerDTO;
import com.fintaxlabs.fintax.application.service.TaxDisclaimerService;
import com.fintaxlabs.fintax.domain.enums.TaxRegime;
import com.fintaxlabs.fintax.domain.model.TaxComparisonResult;
import com.fintaxlabs.fintax.domain.model.TaxResult;
import com.fintaxlabs.fintax.shared.util.MoneyUtils;

import java.util.HashMap;
import java.util.Map;

public class TaxComparisonMapper {

    public static TaxComparisonResponseDTO toResponse(
            TaxComparisonResult domain,
            TaxDisclaimerService disclaimerService
    ) {

        TaxComparisonResponseDTO response = new TaxComparisonResponseDTO();
        response.setBestRegime(domain.getBestRegime().name());
        response.setEconomy(domain.getEconomy());
        response.setComparisonSummary(
                disclaimerService.comparisonSummary(domain.getBestRegime())
        );

        Map<String, TaxResultWithDisclaimerDTO> results = new HashMap<>();

        for (Map.Entry<TaxRegime, TaxResult> entry : domain.getResults().entrySet()) {

            TaxRegime regime = entry.getKey();
            TaxResult result = entry.getValue();

            TaxResultWithDisclaimerDTO dto = new TaxResultWithDisclaimerDTO();
            dto.setTaxDeclarationId(result.getTaxDeclarationId());
            dto.setRegime(regime.name());
            dto.setGrossIncome(MoneyUtils.scale(result.getGrossIncome()));
            dto.setTotalDeductions(MoneyUtils.scale(result.getTotalDeductions()));
            dto.setTaxableBase(MoneyUtils.scale(result.getTaxableBase()));
            dto.setTaxDue(MoneyUtils.scale(result.getTaxDue()));
            dto.setRefund(result.getRefund());
            dto.setDisclaimer(disclaimerService.forRegime(regime));

            results.put(regime.name(), dto);
        }

        response.setResults(results);
        return response;
    }
}
