package io.github.tiagoadmstz.blocks.zero;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.List;

/**
 * Registro 0035 - Identificação de Sociedade em Conta de Participação – SCP
 */
@Data
public class IdentificacaoScp implements EfdBlockPart {

    private final String register = "0035";
    private Number codScp;
    private String descScp;
    private String infComp;

    @Override
    public void setByLine(final List<String> blockLines) {
        final List<String> valuesLine = getValuesLine(blockLines, register);
        if (!valuesLine.isEmpty()) setByLine(valuesLine.getFirst());
    }

    @Override
    public void setByLine(final String valuesLine) {
        final String[] values = splitLine(valuesLine);
        codScp = parseNumber(values[2]);
        descScp = parseString(values[3]);
        infComp = parseString(values[4]);
    }
}
