package com.fintaxlabs.fintax.adapter.output.persistence.entiity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "taxpayer")
public class TaxpayerEntity {

    @Id
    private UUID id;

    private String fullName;

    private String taxId;

    private LocalDate birthDate;

    private boolean hasDependents;

    public TaxpayerEntity() { }

    public TaxpayerEntity(UUID id, String fullName, String taxId, LocalDate birthDate, boolean hasDependents) {
        this.id = id;
        this.fullName = fullName;
        this.taxId = taxId;
        this.birthDate = birthDate;
        this.hasDependents = hasDependents;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isHasDependents() {
        return hasDependents;
    }

    public void setHasDependents(boolean hasDependents) {
        this.hasDependents = hasDependents;
    }
}
