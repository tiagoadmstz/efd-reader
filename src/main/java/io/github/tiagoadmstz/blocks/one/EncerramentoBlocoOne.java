package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro 1990: Encerramento do Bloco 1.
 */
@Data
public class EncerramentoBlocoOne implements EfdBlockPart {

    private final String register = "1990";
    private String qtdLinOne;
}
