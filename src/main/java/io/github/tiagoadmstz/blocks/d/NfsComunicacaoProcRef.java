package io.github.tiagoadmstz.blocks.d;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro D509: Processo Referenciado.
 */
@Data
public class NfsComunicacaoProcRef implements EfdBlockPart {

    private final String register = "D509";
    private String numProc;
    /**
     * Indicador da origem do processo:
     * 1 - Justiça Federal;
     * 3 – Secretaria da Receita Federal do Brasil;
     * 9 – Outros.
     */
    private String indProc;
}
