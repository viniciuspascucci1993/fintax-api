package com.fintaxlabs.fintax.adapter.output.persistence.mapper;

import com.fintaxlabs.fintax.adapter.output.persistence.entiity.TaxResultEntity;
import com.fintaxlabs.fintax.domain.model.TaxResult;

public class TaxResultEntityMapper {

    public TaxResultEntity toEntity(TaxResult domain) {
        TaxResultEntity entity = new TaxResultEntity();
        entity.setTaxDeclarationId(domain.getTaxDeclarationId());
        entity.setTaxRegime(domain.getTaxRegime());
        entity.setGrossIncome(domain.getGrossIncome());
        entity.setTotalDeductions(domain.getTotalDeductions());
        entity.setTaxableBase(domain.getTaxableBase());
        entity.setTaxDue(domain.getTaxDue());
        entity.setRefund(domain.getRefund());
        return entity;
    }

    public TaxResult toDomain(TaxResultEntity entity) {
        return new TaxResult(
                entity.getTaxDeclarationId(),
                entity.getTaxRegime(),
                entity.getGrossIncome(),
                entity.getTotalDeductions(),
                entity.getTaxableBase(),
                entity.getTaxDue(),
                entity.getRefund()
        );
    }
}
