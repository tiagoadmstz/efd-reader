package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro C175: Registro Analítico do Documento (Código 65).
 */
@Data
public class RegistroAnaliticoDocumento implements EfdBlockPart {

    private final String register = "C175";
    private BigDecimal cfop;
    private BigDecimal vlOpr;
    private BigDecimal vlDesc;
    private BigDecimal cstPis;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal quantBcPis;
    private BigDecimal aliqPisQuant;
    private BigDecimal vlPis;
    private BigDecimal cstCofins;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal quantBcCofins;
    private BigDecimal aliqCofinsQuant;
    private BigDecimal vlCofins;
    private String codCta;
    private String infoCompl;
}
