package io.github.tiagoadmstz.blocks.p;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Registro P100: Contribuição Previdenciária sobre a Receita Bruta.
 */
@Data
public class ContribuicaoPrevidenciariaReceitaBruta implements EfdBlockPart {

    private final String register = "P100";
    private String dtIni;
    private String dtFin;
    private String vlRecTotEst;
    private String codAtivEcon;
    private String vlRecAtivEstab;
    private String vlExc;
    private String vlBcCont;
    private String aliquota;
    private String vlContApu;
    private String codCta;
    private String infoCompl;
    private final List<CompEscrDetApuracaoContribuicao> compEscrDetApuracaoContribuicoes;
    private final List<CompEscrDetApuracaoContribuicaoProcRef> compEscrDetApuracaoContribuicaoProcRefs;

    public ContribuicaoPrevidenciariaReceitaBruta() {
        this.compEscrDetApuracaoContribuicoes = new ArrayList<>(1);
        this.compEscrDetApuracaoContribuicaoProcRefs = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "P110", compEscrDetApuracaoContribuicoes, CompEscrDetApuracaoContribuicao.class);
        setPartListByBlock(blockLines, "P199", compEscrDetApuracaoContribuicaoProcRefs, CompEscrDetApuracaoContribuicaoProcRef.class);
    }
}
