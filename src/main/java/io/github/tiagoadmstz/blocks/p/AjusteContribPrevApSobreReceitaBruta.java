package io.github.tiagoadmstz.blocks.p;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro P210: Ajuste da Contribuição Previdenciária Apurada Sobre a Receita Bruta.
 */
@Data
public class AjusteContribPrevApSobreReceitaBruta implements EfdBlockPart {

    private final String register = "P210";
    private String indAj;
    private BigDecimal vlAj;
    private String codAj;
    private String numDoc;
    private String descrAj;
    private String dtRef;
}
