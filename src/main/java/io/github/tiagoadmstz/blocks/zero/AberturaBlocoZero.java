package io.github.tiagoadmstz.blocks.zero;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.List;

@Data
public class AberturaBlocoZero implements EfdBlockPart {

    private String register = "0001";
    /**
     * 0 - Bloco com dados informados;
     * 1 – Bloco sem dados informados.
     */
    private Number identificadorMovimento;

    @Override
    public void setByLine(List<String> blockLines) {
        final List<String> valuesLine = getValuesLine(blockLines, register);
        if (!valuesLine.isEmpty()) setByLine(valuesLine.getFirst());
    }

    @Override
    public void setByLine(String valuesLine) {
        final String[] values = splitLine(valuesLine);
        identificadorMovimento = parseNumber(values[2]);
    }
}
