package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro M110: Ajustes do Crédito de PIS/PASEP Apurado.
 */
@Data
public class AjustesCreditoPisPasepApurado implements EfdBlockPart {

    private final String register = "M110";
    private String indAj;
    private BigDecimal vlAj;
    private String codAj;
    private String numDoc;
    private String descrAj;
    private String dtRef;
    private final List<DetalhamentoAjustesCreditoPisApurado> detalhamentoAjustesCreditoPisApurados;

    public AjustesCreditoPisPasepApurado() {
        this.detalhamentoAjustesCreditoPisApurados = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "M115", detalhamentoAjustesCreditoPisApurados, DetalhamentoAjustesCreditoPisApurado.class);
    }
}
