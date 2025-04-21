package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Registro C400: Equipamento ECF (Códigos 02 e 2D).
 */
@Data
public class EquiapmentoEcf implements EfdBlockPart {

    private final String register = "C400";
    private String codMod;
    private String ecfMod;
    private String ecfFab;
    private Number ecfCx;
    private final List<ReducaoZ> reducoesZ;
    private final List<ResumoDiarioProcReferenciado> resumoDiarioProcReferenciados;

    public EquiapmentoEcf() {
        this.reducoesZ = new ArrayList<>(1);
        this.resumoDiarioProcReferenciados = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        final Set<String> childRegisters = Set.of("C405", "C481", "C485");
        setPartListByBlock(blockLines, "C405", reducoesZ, ReducaoZ.class, childRegisters);
        setPartListByBlock(blockLines, "C489", resumoDiarioProcReferenciados, ResumoDiarioProcReferenciado.class);
    }
}
