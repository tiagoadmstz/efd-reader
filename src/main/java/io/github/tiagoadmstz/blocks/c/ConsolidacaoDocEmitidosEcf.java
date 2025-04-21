package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Registro C490: Consolidação de Documentos Emitidos por ECF (Códigos 02, 2D, 59 e 60).
 */
@Data
public class ConsolidacaoDocEmitidosEcf implements EfdBlockPart {

    private final String register = "C490";
    private LocalDate dtDocIni;
    private LocalDate dtDocFin;
    private String codMod;
    private final List<ConsolidacaoDocEmitidosEcfPis> consolidacaoDocEmitidosEcfPis;
    private final List<ConsolidacaoDocEmitidosEcfCofins> consolidacaoDocEmitidosEcfCofins;
    private final List<DetalhamentoConsolidacaoProcRef> detalhamentoConsolidacaoProcRefs;

    public ConsolidacaoDocEmitidosEcf() {
        this.consolidacaoDocEmitidosEcfPis = new ArrayList<>(1);
        this.consolidacaoDocEmitidosEcfCofins = new ArrayList<>(1);
        this.detalhamentoConsolidacaoProcRefs = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "C491", consolidacaoDocEmitidosEcfPis, ConsolidacaoDocEmitidosEcfPis.class);
        setPartListByBlock(blockLines, "C495", consolidacaoDocEmitidosEcfCofins, ConsolidacaoDocEmitidosEcfCofins.class);
        setPartListByBlock(blockLines, "C499", detalhamentoConsolidacaoProcRefs, DetalhamentoConsolidacaoProcRef.class);
    }
}
