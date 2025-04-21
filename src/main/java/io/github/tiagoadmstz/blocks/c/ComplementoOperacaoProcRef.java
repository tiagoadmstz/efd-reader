package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro C509: Processo Referenciado.
 */
@Data
public class ComplementoOperacaoProcRef implements EfdBlockPart {

    private final String register = "C509";
    private String numProc;
    /**
     * Indicador da origem do processo:
     * 1 - Justiça Federal;
     * 3 – Secretaria da Receita Federal do Brasil
     * 9 - Outros.
     */
    private String indProc;
}
