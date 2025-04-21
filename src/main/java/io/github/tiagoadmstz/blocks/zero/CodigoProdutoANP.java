package io.github.tiagoadmstz.blocks.zero;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro 206: Código de Produto Conforme Tabela ANP (Combustíveis).
 */
@Data
public class CodigoProdutoANP implements EfdBlockPart {

    private final String register = "0206";
    private String codComb;
}
