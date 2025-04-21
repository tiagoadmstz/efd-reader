package io.github.tiagoadmstz.blocks.p;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro P001: Abertura do Bloco P.
 */
@Data
public class AberturaBlocoP implements EfdBlockPart {

    private final String register = "P001";
    /**
     * Indicador de movimento:
     * 0 - Bloco com dados informados;
     * 1 - Bloco sem dados informados
     */
    private String indMov;
}
