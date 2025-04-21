package io.github.tiagoadmstz.blocks.f;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro F210: Operações da Atividade Imobiliária - Custo Orçado da Unidade Imobiliária Vendida.
 */
@Data
public class OpAtividadeImobCustoOrcUnidImobVendida implements EfdBlockPart {

    private final String register = "F210";
    private BigDecimal vlCusOrc;
    private BigDecimal vlExc;
    private BigDecimal vlCusOrcAju;
    private BigDecimal vlBcCred;
    private Number cstPis;
    private BigDecimal aliqPis;
    private BigDecimal vlCredPisUtil;
    private Number cstCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCredCofinsUtil;
}
