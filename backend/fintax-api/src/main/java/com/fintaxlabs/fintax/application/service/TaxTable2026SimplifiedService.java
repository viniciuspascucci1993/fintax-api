package com.fintaxlabs.fintax.application.service;

import com.fintaxlabs.fintax.application.service.bracket.TaxBracket;
import com.fintaxlabs.fintax.domain.taxrule.TaxTable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TaxTable2026SimplifiedService implements TaxTable {

    private final List<TaxBracket> brackets;

    public TaxTable2026SimplifiedService() {
        this.brackets = List.of(
                new TaxBracket(BigDecimal.ZERO, new BigDecimal("27000"), BigDecimal.ZERO),
                new TaxBracket(new BigDecimal("27000"), new BigDecimal("40000"), new BigDecimal("0.075")),
                new TaxBracket(new BigDecimal("40000"), new BigDecimal("55000"), new BigDecimal("0.15")),
                new TaxBracket(new BigDecimal("55000"), null, new BigDecimal("0.225"))
        );
    }

    @Override
    public BigDecimal calculate(BigDecimal taxableBase) {

        // Progressivo real, precisamos:
        //Percorrer TODAS as faixas
        //Calcular a parcela tributável de cada faixa
        //Somar tudo

        BigDecimal tax = BigDecimal.ZERO;

        for (TaxBracket taxBracket : brackets) {
            BigDecimal min = taxBracket.getMin();
            BigDecimal max = taxBracket.getMax();
            BigDecimal rate = taxBracket.getRate();

            if (taxableBase.compareTo(min) > 0) {

                BigDecimal upperLimit =
                        (max == null || taxableBase.compareTo(max) < 0)
                        ? taxableBase
                                : max;

                BigDecimal tableAmount = upperLimit.subtract(min);

                if (tableAmount.compareTo(BigDecimal.ZERO) > 0) {
                    tax = tax.add(
                            tableAmount.multiply(rate)
                    );
                }
            }
        }

        return tax.setScale(2, RoundingMode.HALF_UP);
    }
}
