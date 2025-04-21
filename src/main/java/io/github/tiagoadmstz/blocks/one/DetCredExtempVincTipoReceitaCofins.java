package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Detalhamento do Crédito Extemporâneo, Vinculado a mais de um Tipo de Receita – COFINS
 */
@Data
public class DetCredExtempVincTipoReceitaCofins implements EfdBlockPart {

    private final String register = "1502";
    private BigDecimal vlCredCofinsTribMi;
    private BigDecimal vlCredCofinsNtMi;
    private BigDecimal vlCredCofinsExp;
}
