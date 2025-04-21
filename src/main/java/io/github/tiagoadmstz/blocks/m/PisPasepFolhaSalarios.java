package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro M350: 	PIS/PASEP - Folha de Salários.
 */
@Data
public class PisPasepFolhaSalarios implements EfdBlockPart {

    private final String register = "M350";
    private BigDecimal vlTotFol;
    private BigDecimal vlExcBc;
    private BigDecimal vlTotBc;
    private BigDecimal aliqPisFol;
    private BigDecimal vlTotContFol;
}
