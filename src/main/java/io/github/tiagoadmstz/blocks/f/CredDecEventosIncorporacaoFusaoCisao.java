package io.github.tiagoadmstz.blocks.f;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro F800: Créditos Decorrentes de Eventos de Incorporação, Fusão e Cisão.
 */
@Data
public class CredDecEventosIncorporacaoFusaoCisao implements EfdBlockPart {

    private final String register = "F800";
    /**
     * Indicador da Natureza do Evento de Sucessão:
     * 01 – Incorporação;
     * 02 – Fusão;
     * 03 – Cisão Total;
     * 04 – Cisão Parcial;
     * 99 – Outros.
     */
    private String indNatEven;
    private String dtEven;
    private String cnpjSucede;
    private String paContCred;
    private String codCred;
    private BigDecimal vlCredPis;
    private BigDecimal vlCredCofins;
    private BigDecimal perCredCis;
}
