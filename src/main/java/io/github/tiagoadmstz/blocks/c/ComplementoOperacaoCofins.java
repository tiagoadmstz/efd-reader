package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro C505: Complemento da Operação (Códigos 06, 28 e 29) – Cofins.
 */
@Data
public class ComplementoOperacaoCofins implements EfdBlockPart {

    private final String register = "C505";
    private Number cstCofins;
    private BigDecimal vlItem;
    private String natBcCred;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCofins;
    private String codCta;
}
