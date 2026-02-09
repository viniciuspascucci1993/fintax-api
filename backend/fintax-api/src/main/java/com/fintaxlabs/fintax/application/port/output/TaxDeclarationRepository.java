package com.fintaxlabs.fintax.application.port.output;

import com.fintaxlabs.fintax.domain.model.TaxDeclaration;

public interface TaxDeclarationRepository {

    void save(TaxDeclaration taxDeclaration);
}
