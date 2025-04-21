package io.github.tiagoadmstz.blocks.d;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro D990: Encerramento do Bloco D.
 */
@Data
public class EncerramentoBlocoD implements EfdBlockPart {

    private final String register = "D990";
    private Number qtdLinD;
}
