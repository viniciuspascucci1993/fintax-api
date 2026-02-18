package com.fintaxlabs.fintax.adapter.output.persistence.mapper;

import com.fintaxlabs.fintax.adapter.output.persistence.entiity.DeductionEmbeddable;
import com.fintaxlabs.fintax.adapter.output.persistence.entiity.IncomeEmbeddable;
import com.fintaxlabs.fintax.adapter.output.persistence.entiity.TaxDeclarationEntity;
import com.fintaxlabs.fintax.adapter.output.persistence.entiity.TaxpayerEntity;
import com.fintaxlabs.fintax.domain.enums.DeductionType;
import com.fintaxlabs.fintax.domain.enums.IncomeType;
import com.fintaxlabs.fintax.domain.exception.DomainException;
import com.fintaxlabs.fintax.domain.model.Deduction;
import com.fintaxlabs.fintax.domain.model.Income;
import com.fintaxlabs.fintax.domain.model.TaxDeclaration;
import com.fintaxlabs.fintax.domain.model.Taxpayer;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class TaxDeclarationEntityMapper {

    public TaxDeclarationEntity toEntity(TaxDeclaration domain) {

        TaxDeclarationEntity entity = new TaxDeclarationEntity();
        entity.setId(domain.getId());
        entity.setFiscalYear(domain.getFiscalYear());
        entity.setRegime(domain.getRegime());

        entity.setTaxpayer(toTaxpayerEntity(domain.getTaxPayer()));
        entity.setIncomes(
                domain.getIncomes()
                        .stream()
                        .map(this::toIncomeEmbeddable)
                        .collect(Collectors.toList())
        );

        entity.setDeductions(
                domain.getDeductions()
                        .stream()
                        .map(this::toDeductionEmbeddable)
                        .collect(Collectors.toList())
        );

        return entity;
    }

    public TaxDeclaration toDomain(TaxDeclarationEntity entity) {
        return new TaxDeclaration(
                entity.getId(),
                entity.getFiscalYear(),
                toTaxpayerDomain(entity.getTaxpayer()),
                entity.getIncomes()
                        .stream()
                        .map(this::toIncomeDomain)
                        .collect(Collectors.toList()),
                entity.getDeductions()
                        .stream()
                        .map(this::toDeductionDomain)
                        .collect(Collectors.toList()),
                entity.getRegime()
        );
    }

    /* ============================
       Helpers — Taxpayer
       ============================ */

    private TaxpayerEntity toTaxpayerEntity(Taxpayer domain) {

        TaxpayerEntity entity = new TaxpayerEntity();
        entity.setFullName(domain.getFullName());
        entity.setTaxId(domain.getTaxId());
        entity.setBirthDate(domain.getBirthDate());
        entity.setHasDependents(domain.getHasDependents());

        return entity;
    }

    private Taxpayer toTaxpayerDomain(TaxpayerEntity entity) {

        return new Taxpayer(
                entity.getId(),
                entity.getFullName(),
                entity.getTaxId(),
                entity.getBirthDate(),
                entity.isHasDependents()
        );
    }

    /* ============================
       Helpers — Income
       ============================ */

    private IncomeEmbeddable toIncomeEmbeddable(Income domain) {

        IncomeEmbeddable embeddable = new IncomeEmbeddable();
        embeddable.setAmount(domain.getAmount());
        embeddable.setType(domain.getType());

        return embeddable;
    }

    private Income toIncomeDomain(IncomeEmbeddable embeddable) {
        return new Income(
                embeddable.getAmount(),
                embeddable.getTaxWithheld() != null ? embeddable.getTaxWithheld() : BigDecimal.ZERO,
                IncomeType.valueOf(embeddable.getType().name())
        );
    }

    /* ============================
       Helpers — Deduction
       ============================ */

    private DeductionEmbeddable toDeductionEmbeddable(Deduction domain) {

        DeductionEmbeddable embeddable = new DeductionEmbeddable();
        embeddable.setAmount(domain.getAmount());
        embeddable.setType(domain.getTypeDeduction());

        return embeddable;
    }

    private Deduction toDeductionDomain(DeductionEmbeddable embeddable) {
        DeductionType type;

        try {
            type = DeductionType.valueOf(embeddable.getType().name());
        } catch (IllegalArgumentException ex) {
            throw new DomainException(
                    "Invalid deduction type persisted: " + embeddable.getType()
            );
        }

        return new Deduction(
                embeddable.getAmount(),
                type
        );
    }
}
