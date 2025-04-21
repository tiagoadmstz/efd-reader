package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Registro M600:Consolidação da Contribuição para a Seguridade Social - COFINS do Período.
 */
@Data
public class ConsContribSeguridadeSocialCofinsPeriodo implements EfdBlockPart {

    private final String register = "M600";
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
    private final List<ContribuicaoSeguridadeSocialCofinsRecolher> contribuicaoSeguridadeSocialCofinsRecolhers;
    private final List<DetalhContribSeguridadeSocialCofinsRecolher> detalhamBaseCalculoCreditoCofinsRecolher;

    public ConsContribSeguridadeSocialCofinsPeriodo() {
        this.contribuicaoSeguridadeSocialCofinsRecolhers = new ArrayList<>(1);
        this.detalhamBaseCalculoCreditoCofinsRecolher = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "M605", contribuicaoSeguridadeSocialCofinsRecolhers, ContribuicaoSeguridadeSocialCofinsRecolher.class);
        final Set<String> childRegisters = Set.of("M610", "M611", "M615", "M620", "M625", "M630");
        setPartListByBlock(blockLines, "M610", detalhamBaseCalculoCreditoCofinsRecolher, DetalhContribSeguridadeSocialCofinsRecolher.class, childRegisters);
    }
}
