package io.github.tiagoadmstz.blocks.i;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro I399: Processo Referenciado.
 */
@Data
public class ComplOpDetReceitasDedExclPerProcRef implements EfdBlockPart {

    private final String register = "I399";
    private String numProc;
    /**
     * Indicador da origem do processo:
     * 1 - Justiça Federal;
     * 3 – Secretaria da Receita Federal do Brasil
     * 9 – Outros.
     */
    private String indProc;
}
