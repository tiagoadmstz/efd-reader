package io.github.tiagoadmstz.blocks;

import io.github.tiagoadmstz.blocks.m.AberturaBlocoM;
import io.github.tiagoadmstz.blocks.m.CofinsDiferidaValoresPagarPeriodo;
import io.github.tiagoadmstz.blocks.m.ConsContribSeguridadeSocialCofinsPeriodo;
import io.github.tiagoadmstz.blocks.m.ConsolidacaoContribuicaoPisPeriodo;
import io.github.tiagoadmstz.blocks.m.ContribuicaoPisDiferidaValoresPagar;
import io.github.tiagoadmstz.blocks.m.CreditoCofinsRelativoPeriodo;
import io.github.tiagoadmstz.blocks.m.CreditoPisPasepRelativoPeriodo;
import io.github.tiagoadmstz.blocks.m.EncerramentoBlocoM;
import io.github.tiagoadmstz.blocks.m.PisPasepFolhaSalarios;
import io.github.tiagoadmstz.blocks.m.ReceitasIsentasAliquotaZeroCofins;
import io.github.tiagoadmstz.blocks.m.ReceitasIsentasContribZeroPis;
import io.github.tiagoadmstz.interfaces.EfdBlock;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Bloco M: Apuração da Contribuição e Crédito de PIS/PASEP e da COFINS.
 */
@Data
public class BlockM implements EfdBlock {

    private final AberturaBlocoM aberturaBlocoM;
    private final List<CreditoPisPasepRelativoPeriodo> creditoPisPasepRelativoPeriodos;
    private final ConsolidacaoContribuicaoPisPeriodo consolidacaoContribuicaoPisPeriodo;
    private final List<ContribuicaoPisDiferidaValoresPagar> contribuicaoPisDiferidaValoresPagars;
    private final PisPasepFolhaSalarios pisPasepFolhaSalarios;
    private final List<ReceitasIsentasContribZeroPis> receitasIsentasContribZeroPis;
    private final List<CreditoCofinsRelativoPeriodo> creditoCofinsRelativoPeriodos;
    private final ConsContribSeguridadeSocialCofinsPeriodo consContribSeguridadeSocialCofinsPeriodo;
    private final List<CofinsDiferidaValoresPagarPeriodo> cofinsDiferidaValoresPagarPeriodos;
    private final List<ReceitasIsentasAliquotaZeroCofins> receitasIsentasAliquotaZeroCofins;
    private final EncerramentoBlocoM encerramentoBlocoM;

    public BlockM() {
        this.aberturaBlocoM = new AberturaBlocoM();
        this.creditoPisPasepRelativoPeriodos = new ArrayList<>(1);
        this.consolidacaoContribuicaoPisPeriodo = new ConsolidacaoContribuicaoPisPeriodo();
        this.contribuicaoPisDiferidaValoresPagars = new ArrayList<>(1);
        this.pisPasepFolhaSalarios = new PisPasepFolhaSalarios();
        this.receitasIsentasContribZeroPis = new ArrayList<>(1);
        this.creditoCofinsRelativoPeriodos = new ArrayList<>(1);
        this.consContribSeguridadeSocialCofinsPeriodo = new ConsContribSeguridadeSocialCofinsPeriodo();
        this.cofinsDiferidaValoresPagarPeriodos = new ArrayList<>(1);
        this.receitasIsentasAliquotaZeroCofins = new ArrayList<>(1);
        this.encerramentoBlocoM = new EncerramentoBlocoM();
    }

    public void setByLineNEW(final List<String> lines) {
        final List<String> blockLines = lines.stream()
                .filter(line -> line.startsWith("M", 1))
                .toList();
        aberturaBlocoM.setByLine(blockLines);
        setPartListByBlock(blockLines, "M100", creditoPisPasepRelativoPeriodos, CreditoPisPasepRelativoPeriodo.class, Set.of("M100", "M105", "M110", "M115", "M200", "M205"));
        consolidacaoContribuicaoPisPeriodo.setByLine(blockLines);
        setPartListByBlock(blockLines, "M300", contribuicaoPisDiferidaValoresPagars, ContribuicaoPisDiferidaValoresPagar.class);
        pisPasepFolhaSalarios.setByLine(blockLines);
        setPartListByBlock(blockLines, "M400", receitasIsentasContribZeroPis, ReceitasIsentasContribZeroPis.class, Set.of("M400", "M410"));
        setPartListByBlock(blockLines, "M500", creditoCofinsRelativoPeriodos, CreditoCofinsRelativoPeriodo.class, Set.of("M500", "M505", "M510", "M515"));
        consContribSeguridadeSocialCofinsPeriodo.setByLine(blockLines);
        setPartListByBlock(blockLines, "M700", cofinsDiferidaValoresPagarPeriodos, CofinsDiferidaValoresPagarPeriodo.class);
        setPartListByBlock(blockLines, "M800", receitasIsentasAliquotaZeroCofins, ReceitasIsentasAliquotaZeroCofins.class, Set.of("M800", "M810"));
        encerramentoBlocoM.setByLine(blockLines);
    }
}
