package io.github.tiagoadmstz.blocks.nine;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro 9990: Encerramento do Bloco 9.
 */
@Data
public class EncerramentoBlocoNine implements EfdBlockPart {

    private final String register = "9990";
    private String qtdLinNine;
}
