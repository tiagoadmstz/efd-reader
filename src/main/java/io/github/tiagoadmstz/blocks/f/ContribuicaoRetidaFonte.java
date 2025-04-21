package io.github.tiagoadmstz.blocks.f;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro F600: Contribuição Retida na Fonte.
 */
@Data
public class ContribuicaoRetidaFonte implements EfdBlockPart {

    private final String register = "F600";
    /**
     * Indicador de Natureza da Retenção na Fonte:
     * 01 - Retenção por Órgãos, Autarquias e Fundações Federais;
     * 02 - Retenção por outras Entidades da Administração Pública Federal;
     * 03 - Retenção por Pessoas Jurídicas de Direito Privado;
     * 04 - Recolhimento por Sociedade Cooperativa;
     * 05 - Retenção por Fabricante de Máquinas e Veículos;
     * 99 - Outras Retenções.
     */
    private String indNatRet;
    private String dtRet;
    private BigDecimal vlBcRet;
    private BigDecimal vlRet;
    private String codRec;
    /**
     * Indicador da Natureza da Receita:
     * 0 – Receita de Natureza Não Cumulativa;
     * 1 – Receita de Natureza Cumulativa.
     */
    private String indNatRec;
    private String cnpj;
    private BigDecimal vlRetPis;
    private BigDecimal vlRetCofins;
    /**
     * Indicador da condição da pessoa jurídica declarante:
     * 0 – Beneficiária da Retenção / Recolhimento;
     * 1 – Responsável pelo Recolhimento.
     */
    private String indDec;
}
