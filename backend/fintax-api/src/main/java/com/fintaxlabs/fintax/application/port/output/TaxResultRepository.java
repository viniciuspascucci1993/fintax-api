package com.fintaxlabs.fintax.application.port.output;

import com.fintaxlabs.fintax.domain.model.TaxResult;

public interface TaxResultRepository {

    void save(TaxResult result);
}
