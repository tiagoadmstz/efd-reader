package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro C870: Resumo Diário de Documentos Emitidos por Equipamento SAT-Cf-e (Código 59) – PIS/Pasep e Cofins.
 */
@Data
public class ResumoDiarioSatCfePisCofins implements EfdBlockPart {

    private final String register = "C870";
    private String codItem;
    private Number cfop;
    private BigDecimal vlItem;
    private BigDecimal vlDesc;
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
