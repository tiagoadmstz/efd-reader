package io.github.tiagoadmstz.blocks.i;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Registro I300: Complemento das Operações – Detalhamento das Receitas, Deduções e/ou Exclusões Do Período.
 */
@Data
public class ComplOpDetReceitasDeducoesExclPer implements EfdBlockPart {

    private final String register = "I300";
    private String codComp;
    private String detValor;
    private String codCta;
    private String infoCompl;
    private final List<ComplOpDetReceitasDedExclPerProcRef> complOpDetReceitasDedExclPerProcRefs;

    public ComplOpDetReceitasDeducoesExclPer() {
        this.complOpDetReceitasDedExclPerProcRefs = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "I399", complOpDetReceitasDedExclPerProcRefs, ComplOpDetReceitasDedExclPerProcRef.class);
    }
}
