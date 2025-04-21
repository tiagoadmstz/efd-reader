package io.github.tiagoadmstz.blocks.d;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro D501: Complemento da Operação (Códigos 21 e 22) – PIS/Pasep.
 */
@Data
public class ComplementoOperacaoPisPasep implements EfdBlockPart {

    private final String register = "D501";
    private Number cstPis;
    private BigDecimal vlItem;
    private String natBcCred;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal vlPis;
    private String codCta;
}
