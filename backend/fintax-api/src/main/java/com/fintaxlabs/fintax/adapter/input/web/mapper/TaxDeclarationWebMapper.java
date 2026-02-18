package com.fintaxlabs.fintax.adapter.input.web.mapper;

import com.fintaxlabs.fintax.adapter.input.web.dto.response.DeductionResponseDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.response.IncomeResponseDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.response.TaxDeclarationResponseDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.response.TaxpayerResponseDTO;
import com.fintaxlabs.fintax.domain.model.Deduction;
import com.fintaxlabs.fintax.domain.model.Income;
import com.fintaxlabs.fintax.domain.model.TaxDeclaration;
import com.fintaxlabs.fintax.domain.model.Taxpayer;

import java.util.stream.Collectors;

public class TaxDeclarationWebMapper {

    public static TaxDeclarationResponseDTO toResponse(TaxDeclaration domain) {

        TaxDeclarationResponseDTO dto = new TaxDeclarationResponseDTO();
        dto.setFiscalYear(domain.getFiscalYear());
        dto.setRegime(domain.getRegime().name());

        dto.setTaxpayer(toTaxpayer(domain.getTaxPayer()));
        dto.setIncomes(
                domain.getIncomes().stream()
                        .map(TaxDeclarationWebMapper::toIncome)
                        .collect(Collectors.toList())
        );
        dto.setDeductions(
                domain.getDeductions().stream()
                        .map(TaxDeclarationWebMapper::toDeduction)
                        .collect(Collectors.toList())
        );

        return dto;
    }

    private static TaxpayerResponseDTO toTaxpayer(Taxpayer taxpayer) {
        TaxpayerResponseDTO dto = new TaxpayerResponseDTO();
        dto.setFullName(taxpayer.getFullName());
        dto.setTaxId(taxpayer.getTaxId());
        dto.setBirthDate(taxpayer.getBirthDate());
        dto.setHasDependents(taxpayer.getHasDependents());
        return dto;
    }

    private static IncomeResponseDTO toIncome(Income income) {
        IncomeResponseDTO dto = new IncomeResponseDTO();
        dto.setType(income.getType().name());
        dto.setAmount(income.getAmount().toPlainString());
        return dto;
    }

    private static DeductionResponseDTO toDeduction(Deduction deduction) {
        DeductionResponseDTO dto = new DeductionResponseDTO();
        dto.setType(deduction.getTypeDeduction().name());
        dto.setAmount(deduction.getAmount().toPlainString());
        return dto;
    }
}
