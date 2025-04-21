package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro C396: Itens do Documento (Códigos 02, 2D, 2E, 59, 60 e 65) – Aquisições/Entradas com Crédito.
 */
@Data
public class ItensDocumentoEntradaCredito implements EfdBlockPart {

    private final String register = "C396";
    private String codItem;
    private BigDecimal vlItem;
    private BigDecimal vlDesc;
    private String natBcCred;
    private Number cstPis;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal vlPis;
    private Number cstCofins;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCofins;
    private String codCta;
}
