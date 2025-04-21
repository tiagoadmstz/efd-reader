package io.github.tiagoadmstz.blocks.i;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro I990: Encerramento do Bloco I
 */
@Data
public class EncerramentoBlocoI implements EfdBlockPart {

    private final String register = "I990";
    private String qtdLinI;
}
