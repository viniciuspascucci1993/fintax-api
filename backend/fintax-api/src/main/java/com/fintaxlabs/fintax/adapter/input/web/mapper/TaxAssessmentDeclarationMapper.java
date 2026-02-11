package com.fintaxlabs.fintax.adapter.input.web.mapper;

import com.fintaxlabs.fintax.adapter.input.web.dto.request.DeductionRequestDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.request.IncomeRequestDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.request.TaxAssessmentRequestDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.request.TaxpayerRequestDTO;
import com.fintaxlabs.fintax.domain.enums.DeductionType;
import com.fintaxlabs.fintax.domain.enums.IncomeType;
import com.fintaxlabs.fintax.domain.model.*;

import java.util.List;

public class TaxAssessmentDeclarationMapper {

    public static TaxAssessmentDeclaration toDomain(
            TaxAssessmentRequestDTO dto
    ) {

        return new TaxAssessmentDeclaration(
                dto.getFiscalYear(),
                mapTaxpayer(dto.getTaxpayer()),
                mapIncomes(dto.getIncomes()),
                mapDeductions(dto.getDeductions()),
                dto.getRegime()
        );
    }

    private static Taxpayer mapTaxpayer(TaxpayerRequestDTO dto) {
        return new Taxpayer(
                null,
                dto.getFullName(),
                dto.getTaxId(),
                dto.getBirthDate(),
                dto.isHasDependents()
        );
    }

    private static List<Income> mapIncomes(List<IncomeRequestDTO> incomes) {
        return incomes.stream()
                .map(i -> new Income(i.getAmount(), IncomeType.valueOf(i.getType())))
                .toList();
    }

    private static List<Deduction> mapDeductions(List<DeductionRequestDTO> deductions) {
        return deductions.stream()
                .map(d -> new Deduction(d.getAmount(), DeductionType.valueOf(d.getType())))
                .toList();
    }
}
