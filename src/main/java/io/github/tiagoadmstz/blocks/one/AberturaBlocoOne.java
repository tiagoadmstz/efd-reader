package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro 1001: Abertura do Bloco 1.
 */
@Data
public class AberturaBlocoOne implements EfdBlockPart {

    private final String register = "1001";
    /**
     * Indicador de movimento:
     * 0 - Bloco com dados informados;
     * 1 - Bloco sem dados informados
     */
    private String indMov;
}
