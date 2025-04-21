package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro M990: Encerramento do Bloco M.
 */
@Data
public class EncerramentoBlocoM implements EfdBlockPart {

    private final String register = "M990";
    private String qtdLinM;
}
