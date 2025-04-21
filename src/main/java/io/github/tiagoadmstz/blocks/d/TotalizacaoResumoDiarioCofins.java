package io.github.tiagoadmstz.blocks.d;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro D205: Totalização do Resumo Diário – Cofins.
 */
@Data
public class TotalizacaoResumoDiarioCofins implements EfdBlockPart {

    private final String register = "D205";
    private Number cstCofins;
    private BigDecimal vlItem;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCofins;
    private String codCta;
}
