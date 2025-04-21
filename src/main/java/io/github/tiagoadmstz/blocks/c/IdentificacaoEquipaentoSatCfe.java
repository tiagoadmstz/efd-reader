package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro C860: Identificação do Equipamento SAT-CF-e.
 */
@Data
public class IdentificacaoEquipaentoSatCfe implements EfdBlockPart {

    private final String register = "C860";
    private String codMod;
    private Number nrSat;
    private LocalDate dtDoc;
    private Number docIni;
    private Number docFim;
    private final List<ResumoDiarioSatCfePisCofins> resumoDiarioSatCfePisCofins;
    private final List<ResumoDiarioSatCfePisCofinsUnid> resumoDiarioSatCfePisCofinsUnids;
    private final List<SatCfeProcessoReferenciado> satCfeProcessoReferenciados;

    public IdentificacaoEquipaentoSatCfe() {
        resumoDiarioSatCfePisCofins = new ArrayList<>(1);
        resumoDiarioSatCfePisCofinsUnids = new ArrayList<>(1);
        satCfeProcessoReferenciados = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "C870", resumoDiarioSatCfePisCofins, ResumoDiarioSatCfePisCofins.class);
        setPartListByBlock(blockLines, "C880", resumoDiarioSatCfePisCofinsUnids, ResumoDiarioSatCfePisCofinsUnid.class);
        setPartListByBlock(blockLines, "C890", satCfeProcessoReferenciados, SatCfeProcessoReferenciado.class);
    }
}
