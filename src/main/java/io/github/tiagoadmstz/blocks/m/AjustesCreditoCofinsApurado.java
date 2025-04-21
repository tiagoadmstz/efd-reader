package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro M510: 	Ajustes do Crédito de COFINS Apurado.
 */
@Data
public class AjustesCreditoCofinsApurado implements EfdBlockPart {

    private final String register = "M510";
    private String indAj;
    private BigDecimal vlAj;
    private String codAj;
    private String numDoc;
    private String descrAj;
    private String dtRef;
    private final List<DetalhamentoAjustesCreditoCofinsApurado> detalhamentoAjustesCreditoCofinsApurados;

    public AjustesCreditoCofinsApurado() {
        detalhamentoAjustesCreditoCofinsApurados = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "M515", detalhamentoAjustesCreditoCofinsApurados, DetalhamentoAjustesCreditoCofinsApurado.class);
    }
}
