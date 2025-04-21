package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Registro M200: Consolidação da Contribuição para o PIS/PASEP do Período.
 */
@Data
public class ConsolidacaoContribuicaoPisPeriodo implements EfdBlockPart {

    private final String register = "M200";
    private BigDecimal vlTotContNcPer;
    private BigDecimal vlTotCredDesc;
    private BigDecimal vlTotCredDescAnt;
    private BigDecimal vlTotContNcDev;
    private BigDecimal vlRetNc;
    private BigDecimal vlOutDedNc;
    private BigDecimal vlContNcRec;
    private BigDecimal vlTotContCumPer;
    private BigDecimal vlRetCum;
    private BigDecimal vlOutDedCum;
    private BigDecimal vlContCumRec;
    private BigDecimal vlTotContRec;
    private final List<ContribuicaoPisRecolherVisaoDebitoDCTF> contribuicaoPisRecolherVisaoDebitoDCTFList;
    private final List<DetalhamentoContribPisPeriodo> detalhamentoContribPisPeriodos;

    public ConsolidacaoContribuicaoPisPeriodo() {
        this.contribuicaoPisRecolherVisaoDebitoDCTFList = new ArrayList<>(1);
        this.detalhamentoContribPisPeriodos = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "M205", contribuicaoPisRecolherVisaoDebitoDCTFList, ContribuicaoPisRecolherVisaoDebitoDCTF.class);
        setPartListByBlock(blockLines, "M210", detalhamentoContribPisPeriodos, DetalhamentoContribPisPeriodo.class, Set.of("M210", "M215", "M220", "M230"));
    }
}
