package io.github.tiagoadmstz.blocks.f;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro F001: Abertura do Bloco F.
 */
@Data
public class AberturaBlocoF implements EfdBlockPart {

    private final String register = "F001";
    /**
     * Indicador de movimento:
     * 0- Bloco com dados informados;
     * 1- Bloco sem dados informados
     */
    private String indMov;
}
