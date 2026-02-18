package com.fintaxlabs.fintax.adapter.input.web.mapper;

import com.fintaxlabs.fintax.adapter.input.web.dto.request.TaxpayerRequestDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.response.TaxAssessmentResponseDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.response.TaxAssessmentSummaryDTO;
import com.fintaxlabs.fintax.adapter.input.web.dto.response.TaxpayerResponseDTO;
import com.fintaxlabs.fintax.domain.model.TaxAssessment;
import com.fintaxlabs.fintax.domain.model.TaxAssessmentSummary;
import com.fintaxlabs.fintax.domain.model.Taxpayer;


public class TaxAssessmentResponseMapper {

    public static TaxAssessmentResponseDTO fromDomain(
            TaxAssessment assessment
    ) {

        TaxAssessmentResponseDTO dto = new TaxAssessmentResponseDTO();

        dto.setFiscalYear(assessment.getFiscalYear());
        dto.setTaxpayer(mapTaxpayer(assessment.getTaxpayer()));
        dto.setSummary(mapSummary(assessment.getSummary()));
        dto.setMessages(assessment.getMessages());

        return dto;
    }

    private static TaxAssessmentSummaryDTO mapSummary(
            TaxAssessmentSummary summary
    ) {
        return new TaxAssessmentSummaryDTO(
                summary.getAnnualIncome(),
                summary.getAnnualDeductions(),
                summary.getTaxableBase(),
                summary.getTaxDue(),
                summary.getTotalTaxWithheld(),
                summary.getAmountToPay(),
                summary.getRefund(),
                summary.getMonthlyTaxDue(),
                summary.isDarfRequired(),
                summary.getInstallmentValue(),
                summary.getStatus()
        );
    }

    private static TaxpayerResponseDTO  mapTaxpayer(Taxpayer dto) {
        return new TaxpayerResponseDTO(
                dto.getFullName(),
                dto.getTaxId(),
                dto.getBirthDate(),
                dto.getHasDependents()
        );
    }
}
