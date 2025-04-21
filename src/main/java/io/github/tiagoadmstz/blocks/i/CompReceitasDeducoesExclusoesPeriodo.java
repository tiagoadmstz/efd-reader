package io.github.tiagoadmstz.blocks.i;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Registro I200: Composição das Receitas, Deduções e/ou Exclusões do Período.
 */
@Data
public class CompReceitasDeducoesExclusoesPeriodo implements EfdBlockPart {

    private final String register = "I200";
    private String numCampo;
    private String codDet;
    private String detValor;
    private String codCta;
    private String infoCompl;
    private final List<CompReceitasDeducoesExcPerProcRef> compReceitasDeducoesExcPerProcRefs;
    private final List<ComplOpDetReceitasDeducoesExclPer> complOpDetReceitasDeducoesExclPers;

    public CompReceitasDeducoesExclusoesPeriodo() {
        this.compReceitasDeducoesExcPerProcRefs = new ArrayList<>(1);
        this.complOpDetReceitasDeducoesExclPers = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "I299", compReceitasDeducoesExcPerProcRefs, CompReceitasDeducoesExcPerProcRef.class);
        setPartListByBlock(blockLines, "I300", complOpDetReceitasDeducoesExclPers, ComplOpDetReceitasDeducoesExclPer.class);
    }
}
