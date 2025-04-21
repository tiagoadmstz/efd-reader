package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro M115: Detalhamento dos Ajustes do Crédito de Pis/Pasep Apurado.
 */
@Data
public class DetalhamentoAjustesCreditoPisApurado implements EfdBlockPart {

    private final String register = "M115";
    private BigDecimal detValorAj;
    private String cstPis;
    private BigDecimal detBcCred;
    private BigDecimal detAliq;
    private String dtOperAj;
    private String descAj;
    private String codCta;
    private String infoCompl;
}
