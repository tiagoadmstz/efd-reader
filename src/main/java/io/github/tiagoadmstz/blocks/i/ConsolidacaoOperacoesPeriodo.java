package io.github.tiagoadmstz.blocks.i;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro I100: Consolidação das Operações do Período.
 */
@Data
public class ConsolidacaoOperacoesPeriodo implements EfdBlockPart {

    private final String register = "I100";
    private BigDecimal vlRec;
    private String cstPisCofins;
    private BigDecimal vlTotDedGer;
    private BigDecimal vlTotDedEsp;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal vlPis;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCofins;
    private String infoCompl;
    private final List<ConsOperacoesPeriodoProcRef> consOperacoesPeriodoProcRefs;
    private final List<CompReceitasDeducoesExclusoesPeriodo> compReceitasDeducoesExclusoesPeriodos;

    public ConsolidacaoOperacoesPeriodo() {
        this.consOperacoesPeriodoProcRefs = new ArrayList<>(1);
        this.compReceitasDeducoesExclusoesPeriodos = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "I199", consOperacoesPeriodoProcRefs, ConsOperacoesPeriodoProcRef.class);
        setPartListByBlock(blockLines, "I200", compReceitasDeducoesExclusoesPeriodos, CompReceitasDeducoesExclusoesPeriodo.class);
    }
}
