package com.fintaxlabs.fintax.adapter.input.web.mapper;

import com.fintaxlabs.fintax.adapter.input.web.dto.response.TaxComparisonResponseDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.response.TaxResultResponseDTO;
import com.fintaxlabs.fintax.domain.enums.TaxRegime;
import com.fintaxlabs.fintax.domain.model.TaxComparisonResult;
import com.fintaxlabs.fintax.domain.model.TaxResult;

import java.util.HashMap;
import java.util.Map;

public class TaxComparisonMapper {

    public static TaxComparisonResponseDTO toResponse(TaxComparisonResult domain, String disclaimer) {

        TaxComparisonResponseDTO response = new TaxComparisonResponseDTO();

        response.setBestRegime(domain.getBestRegime().name());
        response.setEconomy(domain.getEconomy());
        response.setDisclaimer(disclaimer);

        Map<String, TaxResultResponseDTO> results = new HashMap<>();

        for (Map.Entry<TaxRegime, TaxResult> entry : domain.getResults().entrySet()) {
            results.put(
                    entry.getKey().name(),
                    TaxSimulationMapper.toResponse(entry.getValue())
            );
        }

        response.setResults(results);

        return response;
    }
}
