package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro C181: Detalhamento da Consolidação - Operações de Vendas - PIS/Pasep.
 */
@Data
public class OperacaoVendasPisPasep implements EfdBlockPart {

    private final String register = "C181";
    private Number cstPis;
    private Number cfop;
    private BigDecimal vlItem;
    private BigDecimal vlDesc;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal quantBcPis;
    private BigDecimal aliqPisQuant;
    private BigDecimal vlPis;
    private String codCta;
}
