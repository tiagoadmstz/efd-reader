package io.github.tiagoadmstz.blocks.i;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro I001: Abertura do Bloco I.
 */
@Data
public class AberturaBlocoI implements EfdBlockPart {

    private final String register = "I001";
    /**
     * Indicador de movimento:
     * 0- Bloco com dados informados;
     * 1- Bloco sem dados informados.
     */
    private String indMov;
}
