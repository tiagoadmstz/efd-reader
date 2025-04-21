package io.github.tiagoadmstz.blocks.d;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro D201: Totalização do Resumo Diário – PIS/Pasep.
 */
@Data
public class TotalizacaoResumoDiarioPisPasep implements EfdBlockPart {

    private final String register = "D201";
    private Number cstPis;
    private BigDecimal vlItem;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal vlPis;
    private String codCta;
}
