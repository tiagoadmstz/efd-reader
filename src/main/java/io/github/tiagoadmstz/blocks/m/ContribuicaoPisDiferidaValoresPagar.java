package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro M300: Contribuição de PIS/PASEP Diferida em Períodos Anteriores - Valores a Pagar no Período.
 */
@Data
public class ContribuicaoPisDiferidaValoresPagar implements EfdBlockPart {

    private final String register = "M300";
    private String codCont;
    private BigDecimal vlContApurDifer;
    /**
     * Natureza do Crédito Diferido, vinculado à receita tributada no mercado interno, a descontar:
     * 01 – Crédito a Alíquota Básica;
     * 02 – Crédito a Alíquota Diferenciada;
     * 03 – Crédito a Alíquota por Unidade de Produto;
     * 04 – Crédito Presumido da Agroindústria.
     */
    private String natCredDesc;
    private BigDecimal vlCredDescDifer;
    private BigDecimal vlContDiferAnt;
    private String perApur;
    private String dtReceb;
}
