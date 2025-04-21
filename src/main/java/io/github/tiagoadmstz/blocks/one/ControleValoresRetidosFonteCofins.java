package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro 1700: Controle dos Valores Retidos na Fonte – COFINS.
 */
@Data
public class ControleValoresRetidosFonteCofins implements EfdBlockPart {

    private final String register = "1700";
    /**
     * Indicador de Natureza da Retenção na Fonte até 2013:
     * 01 - Retenção por Órgãos, Autarquias e Fundações Federais
     * 02 - Retenção por outras Entidades da Administração Pública Federal
     * 03 - Retenção por Pessoas Jurídicas de Direito Privado
     * 04 - Recolhimento por Sociedade Cooperativa
     * 05 - Retenção por Fabricante de Máquinas e Veículos
     * 99 - Outras Retenções
     * <p>
     * <p>
     * Indicador de Natureza da Retenção na Fonte, a partir de 2014:
     * <p>
     * Retenção Rendimentos sujeitos ao Regime Não Cumulativo (PJ Tributada pelo Lucro Real) e ao Regime Cumulativo (PJ Tributada pelo Lucro Presumido/Arbitrado):
     * 01 - Retenção por Órgãos, Autarquias e Fundações Federais
     * 02 - Retenção por outras Entidades da Administração Pública Federal
     * 03 - Retenção por Pessoas Jurídicas de Direito Privado
     * 04 - Recolhimento por Sociedade Cooperativa
     * 05 - Retenção por Fabricante de Máquinas e Veículos
     * 99 - Outras Retenções - Rendimentos sujeitos à regra geral de incidência (não cumulativa ou cumulativa)
     * <p>
     * Retenção Rendimentos sujeitos ao Regime Cumulativo, auferido por Pessoa Jurídica Tributada pelo Lucro Real:
     * 51 - Retenção por Órgãos, Autarquias e Fundações Federais
     * 52 - Retenção por outras Entidades da Administração Pública Federal
     * 53 - Retenção por Pessoas Jurídicas de Direito Privado
     * 54 - Recolhimento por Sociedade Cooperativa
     * 55 - Retenção por Fabricante de Máquinas e Veículos
     * 59 - Outras Retenções - Rendimentos sujeitos à regra específica de incidência cumulativa (art. 8º da Lei nº 10.637/2002 e art. 10 da Lei nº 10.833/2003)
     */
    private String indNatRet;
    private String prRecRet;
    private BigDecimal vlRetApu;
    private BigDecimal vlRetDed;
    private BigDecimal vlRetPer;
    private BigDecimal vlRetDcomp;
    private BigDecimal sldRet;
}
