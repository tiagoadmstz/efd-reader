package io.github.tiagoadmstz.blocks.d;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro D505: Complemento da Operação (Códigos 21 e 22) – Cofins.
 */
@Data
public class ComplementoOperacaoCofins implements EfdBlockPart {

    private final String register = "D505";
    private Number cstCofins;
    private BigDecimal vlItem;
    private String natBcCred;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCofins;
    private String codCta;
}
