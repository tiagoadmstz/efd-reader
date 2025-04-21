package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro C195: Detalhamento da Consolidação - Operações de Aquisição Com Direito a Crédito, e Operações de Devolução de Compras e Vendas – Cofins.
 */
@Data
public class OperacaoAquisicaoCofins implements EfdBlockPart {

    private final String register = "C195";
    private String cnpjCpfPart;
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
