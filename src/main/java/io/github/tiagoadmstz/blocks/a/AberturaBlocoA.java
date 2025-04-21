package io.github.tiagoadmstz.blocks.a;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro A001: Abertura do Bloco A
 */
@Data
public class AberturaBlocoA implements EfdBlockPart {

    private final String register = "A001";
    /**
     * Indicador de movimento:
     * 0 - Bloco com dados informados;
     * 1 - Bloco sem dados informados.
     */
    private Number indMov;
}
