package com.fintaxlabs.fintax.adapter.output.persistence.entiity;

import com.fintaxlabs.fintax.domain.enums.TaxRegime;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tax_declaration")
public class TaxDeclarationEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    private Integer fiscalYear;

    @Enumerated(EnumType.STRING)
    private TaxRegime regime;

    @ManyToOne
    private TaxpayerEntity taxpayer;

    @ElementCollection
    private List<IncomeEmbeddable> incomes;

    @ElementCollection
    private List<DeductionEmbeddable> deductions;

    public TaxDeclarationEntity() { }

    public TaxDeclarationEntity(UUID id, Integer fiscalYear,
                                TaxRegime regime, TaxpayerEntity taxpayer,
                                List<IncomeEmbeddable> incomes,
                                List<DeductionEmbeddable> deductions) {
        this.id = id;
        this.fiscalYear = fiscalYear;
        this.regime = regime;
        this.taxpayer = taxpayer;
        this.incomes = incomes;
        this.deductions = deductions;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(Integer fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public TaxRegime getRegime() {
        return regime;
    }

    public void setRegime(TaxRegime regime) {
        this.regime = regime;
    }

    public TaxpayerEntity getTaxpayer() {
        return taxpayer;
    }

    public void setTaxpayer(TaxpayerEntity taxpayer) {
        this.taxpayer = taxpayer;
    }

    public List<IncomeEmbeddable> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<IncomeEmbeddable> incomes) {
        this.incomes = incomes;
    }

    public List<DeductionEmbeddable> getDeductions() {
        return deductions;
    }

    public void setDeductions(List<DeductionEmbeddable> deductions) {
        this.deductions = deductions;
    }
}
