package io.github.tiagoadmstz.blocks.d;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro 601: Complemento da Consolidação da Prestação de Serviços (Códigos 21 e 22) - PIS/Pasep.
 */
@Data
public class ComplementoConsolidacaoPrestServPis implements EfdBlockPart {

    private final String register = "D601";
    private Number codClass;
    private BigDecimal vlItem;
    private BigDecimal vlDesc;
    private Number cstPis;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal vlPis;
    private String codCta;
}
