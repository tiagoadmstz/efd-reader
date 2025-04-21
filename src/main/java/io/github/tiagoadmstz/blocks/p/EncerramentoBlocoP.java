package io.github.tiagoadmstz.blocks.p;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro P990: Encerramento do Bloco P.
 */
@Data
public class EncerramentoBlocoP implements EfdBlockPart {

    private final String register = "P990";
    private String qtdLinP;
}
