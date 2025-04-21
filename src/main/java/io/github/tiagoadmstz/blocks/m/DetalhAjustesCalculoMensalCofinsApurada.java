package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro M615: Detalhamento dos Ajustes da Base de Cálculo Mensal da COFINS Apurada.
 */
@Data
public class DetalhAjustesCalculoMensalCofinsApurada implements EfdBlockPart {

    private final String register = "M615";
    /**
     * Indicador do tipo de ajuste da base de cálculo:
     * 0 - Ajuste de redução;
     * 1 - Ajuste de acréscimo.
     */
    private String indAjBc;
    private BigDecimal vlAjBc;
    private String codAjBc;
    private String numDoc;
    private String descrAjBc;
    private String dtRef;
    private String codCta;
    private String cnpj;
    private String infoCompl;
}
