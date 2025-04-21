package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro C810: Detalhamento do Cupom Fiscal Eletrônico (Código 59) – PIS/Pasep e Cofins.
 */
@Data
public class DetalhamentoCfePisCofins implements EfdBlockPart {

    private final String register = "C810";
    private Number cfop;
    private BigDecimal vlItem;
    private String codItem;
    private Number cstPis;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal vlPis;
    private Number cstCofins;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCofins;
    private String codCta;
}
