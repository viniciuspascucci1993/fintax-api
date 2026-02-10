package com.fintaxlabs.fintax.application.service;

import com.fintaxlabs.fintax.domain.exception.DomainException;
import com.fintaxlabs.fintax.domain.model.Deduction;
import com.fintaxlabs.fintax.domain.model.Income;
import com.fintaxlabs.fintax.domain.model.TaxDeclaration;
import com.fintaxlabs.fintax.domain.model.TaxResult;
import com.fintaxlabs.fintax.domain.service.TaxCalculator;

import java.math.BigDecimal;

public abstract class AbstractTaxCalculator implements TaxCalculator {

    @Override
    public TaxResult calculate(TaxDeclaration declaration) {
        validate(declaration);

        BigDecimal grossIncome = calculateGrossIncome(declaration);
        BigDecimal totalDeductions = calculateDeductions(declaration);
        BigDecimal taxableBase = grossIncome.subtract(totalDeductions);

        if (taxableBase.compareTo(BigDecimal.ZERO) < 0) {
            throw new DomainException("Taxable base cannot be negative");
        }

        BigDecimal taxDue = calculateTax(taxableBase);

        return new TaxResult(
                declaration.getId(),
                declaration.getRegime(),
                grossIncome,
                totalDeductions,
                taxableBase,
                taxDue,
                BigDecimal.ZERO
        );
    }

    protected void validate(TaxDeclaration declaration) {
        if (declaration == null) {
            throw new DomainException("Tax declaration cannot be null");
        }
        if (declaration.getIncomes().isEmpty()) {
            throw new DomainException("Tax declaration must contain at least one income");
        }
    }

    protected BigDecimal calculateGrossIncome(TaxDeclaration declaration) {
        return declaration.getIncomes().stream()
                .map(Income::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    protected BigDecimal calculateDeductions(TaxDeclaration declaration) {
        return declaration.getDeductions().stream()
                .map(Deduction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    protected abstract BigDecimal calculateTax(BigDecimal taxableBase);
}
