package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro M220: Ajustes da Contribuição para o PIS/PASEP Apurada.
 */
@Data
public class AjustesContribuicaoPisApurada implements EfdBlockPart {

    private final String register = "M220";
    private String indAj;
    private BigDecimal vlAj;
    private String codAj;
    private String numDoc;
    private String descrAj;
    private String dtRef;
    private final List<DetAjustesContribuicaoPisApurada> detAjustesContribuicaoPisApuradas;

    public AjustesContribuicaoPisApurada() {
        this.detAjustesContribuicaoPisApuradas = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "M225", detAjustesContribuicaoPisApuradas, DetAjustesContribuicaoPisApurada.class);
    }
}
