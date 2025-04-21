package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro C609: Processo Referenciado.
 */
@Data
public class ComplementoConsolidacaoDiariaProcRef implements EfdBlockPart {

    private final String register = "C609";
    private Number numProc;
    /**
     * Indicador da origem do processo:
     * 1 - Justiça Federal;
     * 3 – Secretaria da Receita Federal do Brasil
     * 9 – Outros.
     */
    private String indProc;
}
