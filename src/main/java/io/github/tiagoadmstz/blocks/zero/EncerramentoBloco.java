package io.github.tiagoadmstz.blocks.zero;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registo 0990: Encerramento do Bloco 0.
 */
@Data
public class EncerramentoBloco implements EfdBlockPart {

    private final String register = "0990";
    private Number qtdLin0;
}
