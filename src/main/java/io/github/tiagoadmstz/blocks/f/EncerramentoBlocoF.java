package io.github.tiagoadmstz.blocks.f;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro F990: Encerramento do Bloco F.
 */
@Data
public class EncerramentoBlocoF implements EfdBlockPart {

    private final String register = "F990";
    private Number qtdLinF;
}
