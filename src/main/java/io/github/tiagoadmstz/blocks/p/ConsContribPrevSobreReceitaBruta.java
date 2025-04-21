package io.github.tiagoadmstz.blocks.p;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro P200: Consolidação da Contribuição Previdenciária Sobre a Receita Bruta.
 */
@Data
public class ConsContribPrevSobreReceitaBruta implements EfdBlockPart {

    private final String register = "P200";
    private String perRef;
    private BigDecimal vlTotContApu;
    private BigDecimal vlTotAjReduc;
    private BigDecimal vlTotAjAcres;
    private BigDecimal vlTotContDev;
    private String codRec;
    private List<AjusteContribPrevApSobreReceitaBruta> ajusteContribPrevApSobreReceitaBrutas;

    public ConsContribPrevSobreReceitaBruta() {
        this.ajusteContribPrevApSobreReceitaBrutas = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "P210", ajusteContribPrevApSobreReceitaBrutas, AjusteContribPrevApSobreReceitaBruta.class);
    }
}
