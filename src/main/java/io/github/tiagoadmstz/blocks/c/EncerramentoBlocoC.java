package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro C990: Encerramento do Bloco C
 */
@Data
public class EncerramentoBlocoC implements EfdBlockPart {

    private final String register = "C990";
    private Number qtdLinC;
}
