package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro C499: Processo Referenciado.
 */
@Data
public class DetalhamentoConsolidacaoProcRef implements EfdBlockPart {

    private final String register = "C499";
    private String numProc;
    /**
     * Indicador da origem do processo:
     * 1 - Justiça Federal;
     * 3 – Secretaria da Receita Federal do Brasil
     * 9 - Outros.
     */
    private Number indProc;
}
