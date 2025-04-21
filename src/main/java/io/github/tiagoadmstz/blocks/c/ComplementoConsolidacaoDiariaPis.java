package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro C601: Complemento da Consolidação Diária (Códigos 06, 28 e 29) – Documentos de Saídas - PIS/Pasep.
 */
@Data
public class ComplementoConsolidacaoDiariaPis implements EfdBlockPart {

    private final String register = "C601";
    private Number cstPis;
    private BigDecimal vlItem;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal vlPis;
    private String codCta;
}
