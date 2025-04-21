package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro M211: Sociedades Cooperativas – Composição da Base de Cálculo – PIS/PASEP
 */
@Data
public class SociedadesCooperativasCompCalculoPis implements EfdBlockPart {

    private final String register = "M211";
    /**
     * Indicador do Tipo de Sociedade Cooperativa:
     * 01 – Cooperativa de Produção Agropecuária;
     * 02 – Cooperativa de Consumo;
     * 03 – Cooperativa de Crédito;
     * 04 – Cooperativa de Eletrificação Rural;
     * 05 – Cooperativa de Transporte Rodoviário de Cargas;
     * 06 – Cooperativa de Médicos;
     * 99 – Outras.
     */
    private String indTipCoop;
    private BigDecimal vlBcContAntExcCoop;
    private BigDecimal vlExcCoopGer;
    private BigDecimal vlExcEspCoop;
    private BigDecimal vlBcCont;
}
