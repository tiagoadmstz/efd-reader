package io.github.tiagoadmstz.blocks.nine;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro 9900:
 */
@Data
public class RegistrosArquivo implements EfdBlockPart {

    private final String register = "9900";
    private String regTag;
    private String qtdReg;
}
