package io.github.tiagoadmstz.blocks.a;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro A111: Processo Referenciado.
 */
@Data
public class ProcessoReferenciado implements EfdBlockPart {

    private final String register = "A111";
    private String numProc;
    /**
     * Indicador da origem do processo:
     * 1 - Justiça Federal;
     * 3 – Secretaria da Receita Federal do Brasil;
     * 9 - Outros.
     */
    private String indProc;
}
