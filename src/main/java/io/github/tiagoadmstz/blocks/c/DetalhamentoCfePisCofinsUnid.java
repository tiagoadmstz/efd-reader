package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro C820: Detalhamento do Cupom Fiscal Eletrônico (Código 59) – PIS/Pasep e Cofins Apurado por Unidade de Medida de Produto.
 */
@Data
public class DetalhamentoCfePisCofinsUnid implements EfdBlockPart {

    private final String register = "C820";
    private Number cfop;
    private BigDecimal vlItem;
    private String codItem;
    private Number cstPis;
    private BigDecimal quantBcPis;
    private BigDecimal aliqPisQuant;
    private BigDecimal vlPis;
    private Number cstCofins;
    private BigDecimal quantBcCofins;
    private BigDecimal aliqCofinsQuant;
    private BigDecimal vlCofins;
    private String codCta;
}
