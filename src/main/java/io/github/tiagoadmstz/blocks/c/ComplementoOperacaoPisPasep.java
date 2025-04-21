package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro C501: Complemento da Operação (Códigos 06, 28 e 29) – PIS/Pasep.
 */
@Data
public class ComplementoOperacaoPisPasep implements EfdBlockPart {

    private final String register = "C501";
    private Number cstPis;
    private BigDecimal vlItem;
    private String natBcCred;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal vlPis;
    private String codCta;
}
