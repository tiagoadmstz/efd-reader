package io.github.tiagoadmstz.blocks.a;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

@Data
public class EncerramentoBloco implements EfdBlockPart {

    private final String register = "A990";
    private Number qtdLinA;
}
