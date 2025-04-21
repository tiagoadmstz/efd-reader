package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro C880: Resumo Diário de Documentos Emitidos por Equipamento SAT-Cf-e (Código 59) – PIS/Pasep e Cofins Apurado por Unidade de Medida de Produto.
 */
@Data
public class ResumoDiarioSatCfePisCofinsUnid implements EfdBlockPart {

    private final String register = "C880";
    private String codItem;
    private Number cfop;
    private BigDecimal vlItem;
    private BigDecimal vlDesc;
    private Number cstPis;
    private BigDecimal quantBcPis;
    private BigDecimal aliqPisQuant;
    private BigDecimal vlPis;
    private Number cstCofins;
    private BigDecimal quantBcCofins;
    private BigDecimal aliqCofinsQuant;
    private BigDecimal vlCofins;
    private String codCta;
}
