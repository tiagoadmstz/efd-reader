package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro C185: Detalhamento da Consolidação – Operações de Vendas – Cofins.
 */
@Data
public class OperacaoVendasCofins implements EfdBlockPart {

    private final String register = "C181";
    private Number cstCofins;
    private Number cfop;
    private BigDecimal vlItem;
    private BigDecimal vlDesc;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal quantBcCofins;
    private BigDecimal aliqCofinsQuant;
    private BigDecimal vlCofins;
    private String codCta;
}
