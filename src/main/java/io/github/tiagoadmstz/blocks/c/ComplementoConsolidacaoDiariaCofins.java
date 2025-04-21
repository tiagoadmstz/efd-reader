package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro C605: Complemento da Consolidação Diária (Códigos 06, 28 e 29) – Documentos de Saídas - COFINS.
 */
@Data
public class ComplementoConsolidacaoDiariaCofins implements EfdBlockPart {

    private final String register = "C605";
    private Number cstCofins;
    private BigDecimal vlItem;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCofins;
    private String codCta;
}
