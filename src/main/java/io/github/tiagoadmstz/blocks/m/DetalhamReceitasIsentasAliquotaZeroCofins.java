package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro M810: Detalhamento das Receitas Isentas, Não Alcançadas pela Incidência da Contribuição, Sujeitas a Alíquota Zero ou de Vendas com Suspensão – Cofins.
 */
@Data
public class DetalhamReceitasIsentasAliquotaZeroCofins implements EfdBlockPart {

    private final String register = "M810";
    /**
     * Natureza da Receita, conforme relação constante nas Tabelas de Detalhamento da Natureza da Receita por Situação Tributária abaixo:
     * - Tabela 4.3.10: Produtos Sujeitos à Incidência Monofásica da Contribuição Social – Alíquotas Diferenciadas (CST 04 - Revenda);
     * - Tabela 4.3.11: Produtos Sujeitos à Incidência Monofásica da Contribuição Social – Alíquotas por Unidade de Medida de Produto (CST 04 - Revenda);
     * - Tabela 4.3.12: Produtos Sujeitos à Substituição Tributária da Contribuição Social (CST 05 - Revenda);
     * - Tabela 4.3.13: Produtos Sujeitos à Alíquota Zero da Contribuição Social (CST 06);
     * - Tabela 4.3.14: Operações com Isenção da Contribuição Social (CST 07);
     * - Tabela 4.3.15: Operações sem Incidência da Contribuição Social (CST 08);
     * - Tabela 4.3.16: Operações com Suspensão da Contribuição Social (CST 09).
     */
    private String natRec;
    private BigDecimal vlRec;
    private String codCta;
    private String descCompl;
}
