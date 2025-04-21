package io.github.tiagoadmstz.blocks.f;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro F560: Consolidação das Operações da Pessoa Jurídica Submetida ao Regime de Tributação com Base no Lucro Presumido – Incidência do PIS/Pasep e da Cofins pelo Regime de Competência (Apuração da Contribuição por Unidade de Medida de Produto – Alíquota em Reais).
 */
@Data
public class ConsOpPjSubTribBasePresIncPisCofins implements EfdBlockPart {

    private final String register = "F560";
    private BigDecimal vlRecComp;
    private Number cstPis;
    private BigDecimal vlDescPis;
    private BigDecimal quantBcPis;
    private BigDecimal aliqPis;
    private BigDecimal vlPis;
    private Number cstCofins;
    private BigDecimal vlDescCofins;
    private BigDecimal quantBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCofins;
    private String codMod;
    private String cfop;
    private String codCta;
    private String infoCompl;
    private final List<ConsOpPjSubTribBasePresIncPisCofinsProcRef> consOpPjSubTribBasePresIncPisCofinsProcRefs;

    public ConsOpPjSubTribBasePresIncPisCofins() {
        this.consOpPjSubTribBasePresIncPisCofinsProcRefs = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "F569", consOpPjSubTribBasePresIncPisCofinsProcRefs, ConsOpPjSubTribBasePresIncPisCofinsProcRef.class);
    }
}
