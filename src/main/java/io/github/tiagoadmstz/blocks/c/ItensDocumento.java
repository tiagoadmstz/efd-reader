package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro C170: Complemento do Documento - Itens do Documento (Códigos 01, 1B, 04 e 55)
 */
@Data
public class ItensDocumento implements EfdBlockPart {

    private final String register = "C170";
    private Number numItem;
    private String codItem;
    private String descrCompl;
    private String qtd;
    private String unid;
    private BigDecimal vlItem;
    private BigDecimal vlDesc;
    /**
     * Movimentação física do ITEM/PRODUTO:
     * 0. SIM
     * 1. NÃO
     */
    private String indMov;
    private BigDecimal cstIcms;
    private BigDecimal cfop;
    private String codNat;
    private BigDecimal vlBcIcms;
    private BigDecimal AliqIcms;
    private BigDecimal vlIcms;
    private BigDecimal vlBcIcmsSt;
    private BigDecimal aliqSt;
    private BigDecimal vlIcmsSt;
    /**
     * Indicador de período de apuração do IPI:
     * 0 - Mensal;
     * 1 Decendial
     */
    private String indApur;
    private String cstIpi;
    private String codEnq;
    private BigDecimal vlBcIpi;
    private BigDecimal aliqIpi;
    private BigDecimal vlIpi;
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
}
