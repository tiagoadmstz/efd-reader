package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro M515: Detalhamento dos Ajustes do Crédito de Cofins Apurado.
 */
@Data
public class DetalhamentoAjustesCreditoCofinsApurado implements EfdBlockPart {

    private final String register = "M515";
    private BigDecimal detValorAj;
    private String cstCofins;
    private BigDecimal detBcCred;
    private BigDecimal detAliq;
    private String dtOperAj;
    private String descAj;
    private String codCta;
    private String infoCompl;
}
