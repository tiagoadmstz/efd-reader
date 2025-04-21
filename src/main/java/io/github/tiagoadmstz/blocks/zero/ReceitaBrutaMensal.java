package io.github.tiagoadmstz.blocks.zero;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.List;

/**
 * Registro 0111: Tabela de Receita Bruta Mensal Para Fins de Rateio de Créditos Comuns
 */
@Data
public class ReceitaBrutaMensal implements EfdBlockPart {

    private String reg = "0111";
    private Number recBruNcumTribM;
    private Number recBruNcumNtMi;
    private Number recBruNcumExp;
    private Number recBruCum;
    private Number recBruTotal;


    @Override
    public void setByLine(String valuesLine) {
        final String[] values = splitLine(valuesLine);
        recBruNcumTribM = parseNumber(values[2]);
        recBruNcumNtMi = parseNumber(values[3]);
        recBruNcumExp = parseNumber(values[4]);
        recBruCum = parseNumber(values[5]);
        recBruTotal = parseNumber(values[6]);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        final List<String> valuesLine = getValuesLine(blockLines, reg);
        if (!valuesLine.isEmpty()) setByLine(valuesLine.getFirst());
    }
}
