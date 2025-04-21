package io.github.tiagoadmstz.blocks.f;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro F550: Consolidação das Operações da Pessoa Jurídica Submetida ao Regime de Tributação com Base no Lucro Presumido – Incidência do PIS/Pasep e da Cofins pelo Regime de Competência.
 */
@Data
public class BaseLucroPresIncPisCofinsRegCompet implements EfdBlockPart {

    private final String register = "F550";
    private BigDecimal vlRecComp;
    private Number cstPis;
    private BigDecimal vlDescPis;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal vlPis;
    private Number cstCofins;
    private BigDecimal vlDescCofins;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCofins;
    private String codMod;
    private String cfop;
    private String codCta;
    private String infoCompl;
    private final List<BaseLucroPresIncPisCofinsRegCompetPorcRef> baseLucroPresIncPisCofinsRegCompetPorcRefs;

    public BaseLucroPresIncPisCofinsRegCompet() {
        this.baseLucroPresIncPisCofinsRegCompetPorcRefs = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "F559", baseLucroPresIncPisCofinsRegCompetPorcRefs, BaseLucroPresIncPisCofinsRegCompetPorcRef.class);
    }
}
