package io.github.tiagoadmstz.blocks.d;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro D001: Abertura do Bloco D.
 */
@Data
public class AberturaBlocoD implements EfdBlockPart {

    private final String register = "D001";
    /**
     * Indicador de movimento:
     * 0- Bloco com dados informados;
     * 1- Bloco sem dados informados.
     */
    private String indMov;
}
