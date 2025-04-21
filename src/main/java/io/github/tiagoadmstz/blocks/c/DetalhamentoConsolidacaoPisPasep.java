package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro C381: Detalhamento da Consolidação – PIS/Pasep.
 */
@Data
public class DetalhamentoConsolidacaoPisPasep implements EfdBlockPart {

    private final String register = "C381";
    private Number cstPis;
    private String codItem;
    private BigDecimal vlItem;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal quantBcPis;
    private BigDecimal aliqPisQuant;
    private BigDecimal vlPis;
    private String codCta;
}
