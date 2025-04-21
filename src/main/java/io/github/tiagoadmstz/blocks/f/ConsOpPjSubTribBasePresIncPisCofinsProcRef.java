package io.github.tiagoadmstz.blocks.f;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro F569: Processo Referenciado.
 */
@Data
public class ConsOpPjSubTribBasePresIncPisCofinsProcRef implements EfdBlockPart {

    private final String register = "F569";
    private String numProc;
    /**
     * Indicador da origem do processo:
     * 1 - Justiça Federal;
     * 3 – Secretaria da Receita Federal do Brasil
     * 9 – Outros.
     */
    private String indProc;
}
