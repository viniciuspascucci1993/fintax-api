package com.fintaxlabs.fintax.application.messages;

import com.fintaxlabs.fintax.domain.enums.TaxAssessmentStatus;

import java.util.ArrayList;
import java.util.List;

public class TaxAssessmentMessageBuilder {

    public static List<String> buildMessages(TaxAssessmentStatus status, int fiscalYear) {

        List<String> messages = new ArrayList<>();

        switch (status) {

            case EXEMPT -> {
                messages.add(
                        "Contribuinte isento de Imposto de Renda no ano fiscal de " + fiscalYear + "."
                );
                messages.add(
                        "A base tributável informada está dentro da faixa de isenção."
                );
            }

            case TAX_DUE -> {
                messages.add(
                        "Imposto de Renda devido para o ano fiscal de " + fiscalYear + "."
                );
                messages.add(
                        "O valor foi calculado com base na renda anual informada e nas deduções declaradas."
                );
            }

            case TAX_REFUND -> {
                messages.add(
                        "Contribuinte possui imposto a restituir referente ao ano fiscal de " + fiscalYear + "."
                );
            }
        }

        return messages;
    }
}
