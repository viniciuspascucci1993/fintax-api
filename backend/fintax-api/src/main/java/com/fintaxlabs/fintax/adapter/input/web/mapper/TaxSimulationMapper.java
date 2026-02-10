package com.fintaxlabs.fintax.adapter.input.web.mapper;

import com.fintaxlabs.fintax.adapter.input.web.dto.request.*;
import com.fintaxlabs.fintax.adapter.input.web.dto.response.TaxResultResponseDTO;
import com.fintaxlabs.fintax.domain.enums.DeductionType;
import com.fintaxlabs.fintax.domain.enums.IncomeType;
import com.fintaxlabs.fintax.domain.enums.TaxRegime;
import com.fintaxlabs.fintax.domain.exception.DomainException;
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

        taxResultResponseDTO.setTaxDeclarationId(taxResult.getTaxDeclarationId());
        taxResultResponseDTO.setRegime(taxResult.getTaxRegime().name());
        taxResultResponseDTO.setGrossIncome(taxResult.getGrossIncome());
        taxResultResponseDTO.setTotalDeductions(taxResult.getTotalDeductions());
        taxResultResponseDTO.setTaxableBase(taxResult.getTaxableBase());
        taxResultResponseDTO.setTaxDue(taxResult.getTaxDue());
        taxResultResponseDTO.setRefund(taxResult.getRefund());

        return taxResultResponseDTO;
    }

    public static TaxResultResponseDTO toResponseForComparin(TaxResult taxResult) {

        TaxResultResponseDTO taxResultResponseDTO = new TaxResultResponseDTO();

        taxResultResponseDTO.setTaxDeclarationId(taxResult.getTaxDeclarationId());
        taxResultResponseDTO.setGrossIncome(taxResult.getGrossIncome());
        taxResultResponseDTO.setTotalDeductions(taxResult.getTotalDeductions());
        taxResultResponseDTO.setTaxableBase(taxResult.getTaxableBase());
        taxResultResponseDTO.setTaxDue(taxResult.getTaxDue());
        taxResultResponseDTO.setRefund(taxResult.getRefund());

        return taxResultResponseDTO;
    }

    public static TaxDeclaration toDomainForComparison(CompareTaxRequestDTO compareTaxRequestDTO) {
        return new TaxDeclaration(
                null,
                compareTaxRequestDTO.getFiscalYear(),
                mapTaxpayer(compareTaxRequestDTO.getTaxpayer()),
                mapIncomes(compareTaxRequestDTO.getIncomes()),
                mapDeductions(compareTaxRequestDTO.getDeductions()),
                null // regime será decidido depois
        );
    }

    // HELPERS
    private static Taxpayer mapTaxpayer(TaxpayerRequestDTO dto) {

        if (dto == null) {
            throw new DomainException("Taxpayer cannot be null");
        }

        return new Taxpayer(
                null,
                dto.getFullName(),
                dto.getTaxId(),
                dto.getBirthDate(),
                dto.isHasDependents()
        );

    }

    private static List<Income> mapIncomes(List<IncomeRequestDTO> dtos) {

        if (dtos == null || dtos.isEmpty()) {
            throw new DomainException("List of Incomes cannot be null");
        }

        return dtos.stream()
                .map(incomeRequestDTO -> {
                    try {
                        return new Income(
                                incomeRequestDTO.getAmount(),
                                IncomeType.valueOf(incomeRequestDTO.getType())
                        );

                    } catch (Exception ex) {
                        throw new DomainException(
                                "Invalid income type: " + incomeRequestDTO.getType()
                        );
                    }
                }).toList();
    }

    private static List<Deduction> mapDeductions(List<DeductionRequestDTO> dtos) {

        if (dtos == null || dtos.isEmpty()) {
            throw new DomainException("List of Incomes cannot be null");
        }

        return dtos.stream()
                .map(dto -> {
                    try {
                        return new Deduction(
                                dto.getAmount(),
                                DeductionType.valueOf(dto.getType())
                        );
                    } catch (IllegalArgumentException ex) {
                        throw new DomainException(
                                "Invalid deduction type: " + dto.getType()
                        );
                    }
                })
                .toList();

    }
}
