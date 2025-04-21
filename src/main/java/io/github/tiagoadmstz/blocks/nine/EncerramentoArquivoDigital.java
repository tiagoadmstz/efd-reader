package io.github.tiagoadmstz.blocks.nine;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro 9999: Encerramento de Arquivo Digital.
 */
@Data
public class EncerramentoArquivoDigital implements EfdBlockPart {

    private final String register = "9999";
    private String qtdLinArquivo;
}
