package com.fintaxlabs.fintax.domain.service.impl;

import com.fintaxlabs.fintax.domain.exception.DomainException;
import com.fintaxlabs.fintax.domain.model.Deduction;
import com.fintaxlabs.fintax.domain.model.Income;
import com.fintaxlabs.fintax.domain.model.TaxDeclaration;
import com.fintaxlabs.fintax.domain.model.TaxResult;
import com.fintaxlabs.fintax.domain.service.TaxCalculatorService;

import java.math.BigDecimal;

public class TaxCalculatorServiceImpl implements TaxCalculatorService {
    @Override
    public TaxResult calculate(TaxDeclaration declaration) {

        if (declaration == null) {
            throw new DomainException("Tax declaration cannot be null");
        }

        if (declaration.getIncomes().isEmpty()) {
            throw new DomainException("Tax declaration must contain at least one income");
        }

        // Inicio dos calculos
        BigDecimal grossIncome = declaration.getIncomes().stream()
                .map(Income::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalDeductions = declaration.getDeductions().stream()
                .map(Deduction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal taxableBase = grossIncome.subtract(totalDeductions);

        if (taxableBase.compareTo(BigDecimal.ZERO) < 0) {
            throw new DomainException("Taxable base cannot be negative");
        }

        // Cálculo ficticio ( por enquanto )
        BigDecimal taxDue = taxableBase.multiply(new BigDecimal("0.15"));

        return new TaxResult(declaration.getRegime(),
                grossIncome, totalDeductions,
                taxableBase, taxDue,
                BigDecimal.ZERO);
    }
}
