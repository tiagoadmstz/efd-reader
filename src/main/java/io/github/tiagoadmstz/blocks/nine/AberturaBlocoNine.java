package io.github.tiagoadmstz.blocks.nine;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro 9001: Abertura do Bloco 9.
 */
@Data
public class AberturaBlocoNine implements EfdBlockPart {

    private final String register = "9001";
    private String indMov;
}
