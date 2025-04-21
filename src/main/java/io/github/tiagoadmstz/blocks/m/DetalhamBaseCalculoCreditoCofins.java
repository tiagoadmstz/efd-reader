package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro M505: Detalhamento da Base de Cálculo do Crédito Apurado no Período – COFINS.
 */
@Data
public class DetalhamBaseCalculoCreditoCofins implements EfdBlockPart {

    private final String register = "M505";
    private String natBcCred;
    private String cstCofins;
    private BigDecimal vlBcCofinsTot;
    private BigDecimal vlBcCofinsCum;
    private BigDecimal vlBcCofinsNc;
    private BigDecimal vlBcCofins;
    private BigDecimal quantBcCofinsTot;
    private BigDecimal quantBcCofins;
    private String descCred;
}
