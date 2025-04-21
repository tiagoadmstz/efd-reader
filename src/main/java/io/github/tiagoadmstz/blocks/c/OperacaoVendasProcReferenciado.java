package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro C188: Processo Referenciado.
 */
@Data
public class OperacaoVendasProcReferenciado implements EfdBlockPart {

    private final String register = "C188";
    private String numProc;
    private String cfop;
}
