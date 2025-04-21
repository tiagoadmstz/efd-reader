package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro M620: Ajustes da COFINS Apurada.
 */
@Data
public class AjustesCofinsApurada implements EfdBlockPart {

    private final String register = "M620";
    /**
     * Indicador do tipo de ajuste:
     * 0- Ajuste de redução;
     * 1- Ajuste de acréscimo.
     */
    private String indAj;
    private BigDecimal vlAj;
    private String codAj;
    private String numDoc;
    private String descrAj;
    private String dtRef;
    private final List<DetalhamentoAjustesCofinsApurada> detalhamentoAjustesCofinsApuradas;

    public AjustesCofinsApurada() {
        this.detalhamentoAjustesCofinsApuradas = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "M625", detalhamentoAjustesCofinsApuradas, DetalhamentoAjustesCofinsApurada.class);
    }
}
