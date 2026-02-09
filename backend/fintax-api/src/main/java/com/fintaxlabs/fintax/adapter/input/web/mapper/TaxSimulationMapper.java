package com.fintaxlabs.fintax.adapter.input.web.mapper;

import com.fintaxlabs.fintax.adapter.input.web.dto.request.SimulateTaxRequestDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.response.TaxResultResponseDTO;
import com.fintaxlabs.fintax.domain.enums.DeductionType;
import com.fintaxlabs.fintax.domain.enums.IncomeType;
import com.fintaxlabs.fintax.domain.enums.TaxRegime;
import com.fintaxlabs.fintax.domain.model.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TaxSimulationMapper {

    public static TaxDeclaration toDomain(SimulateTaxRequestDTO simulateTaxRequestDTO) {

        Taxpayer taxpayer = new Taxpayer(
                null,
                simulateTaxRequestDTO.getTaxpayer().getFullName(),
                simulateTaxRequestDTO.getTaxpayer().getTaxId(),
                simulateTaxRequestDTO.getTaxpayer().getBirthDate(),
                simulateTaxRequestDTO.getTaxpayer().isHasDependents()
        );

        List<Income> incomes = simulateTaxRequestDTO.getIncomes().stream()
                .map(i -> new Income(i.getAmount(), IncomeType.valueOf(i.getType())))
                .toList();

        List<Deduction> deductions = simulateTaxRequestDTO.getDeductions().stream()
                .map(d -> new Deduction(d.getAmount(), DeductionType.valueOf(d.getType())))
                .toList();

        return new TaxDeclaration(
                null,
                simulateTaxRequestDTO.getFiscalYear(),
                taxpayer,
                incomes,
                deductions,
                TaxRegime.valueOf(simulateTaxRequestDTO.getRegime())
        );
    }


    public static TaxResultResponseDTO toResponse(TaxResult taxResult) {

        TaxResultResponseDTO taxResultResponseDTO = new TaxResultResponseDTO();

        taxResultResponseDTO.setRegime(taxResult.getTaxRegime().name());
        taxResultResponseDTO.setGrossIncome(taxResult.getGrossIncome());
        taxResultResponseDTO.setTotalDeductions(taxResult.getTotalDeductions());
        taxResultResponseDTO.setTaxableBase(taxResult.getTaxableBase());
        taxResultResponseDTO.setTaxDue(taxResult.getTaxDue());
        taxResultResponseDTO.setRefund(taxResult.getRefund());

        return taxResultResponseDTO;
    }
}
