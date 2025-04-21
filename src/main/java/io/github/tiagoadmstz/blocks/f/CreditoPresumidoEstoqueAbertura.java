package io.github.tiagoadmstz.blocks.f;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro F150: Crédito Presumido sobre Estoque de Abertura.
 */
@Data
public class CreditoPresumidoEstoqueAbertura implements EfdBlockPart {

    private final String register = "F150";
    private String natBcCred;
    private BigDecimal vlTotEst;
    private BigDecimal estImp;
    private BigDecimal vlBcEst;
    private BigDecimal vlBcMenEst;
    private Number cstPis;
    private BigDecimal aliqPis;
    private BigDecimal vlCredPis;
    private Number cstCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCredCofins;
    private String descEst;
    private String codCta;
}
