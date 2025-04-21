package io.github.tiagoadmstz.blocks.f;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro F205: Operações da Atividade Imobiliária – Custo Incorrido da Unidade Imobiliária.
 */
@Data
public class OpAtividadeImobCustoIncorridoUnidImob implements EfdBlockPart {

    private final String register = "F205";
    private BigDecimal vlCusIncAcumAnt;
    private BigDecimal vlCusIncPerEsc;
    private BigDecimal vlCusIncAcum;
    private BigDecimal vlExcBcCusIncAcum;
    private BigDecimal vlBcCusInc;
    private Number cstPis;
    private BigDecimal aliqPis;
    private BigDecimal vlCredPisAcum;
    private BigDecimal vlCredPisDescAnt;
    private BigDecimal vlCredPisDesc;
    private BigDecimal vlCredPisDescFut;
    private Number cstCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCredCofinsAcum;
    private BigDecimal vlCredCofinsDescAnt;
    private BigDecimal vlCredCofinsDesc;
    private BigDecimal vlCredCofinsDescFut;
}
