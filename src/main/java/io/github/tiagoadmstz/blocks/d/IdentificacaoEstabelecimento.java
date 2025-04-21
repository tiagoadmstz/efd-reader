package io.github.tiagoadmstz.blocks.d;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Registro D010: Identificação do Estabelecimento.
 */
@Data
public class IdentificacaoEstabelecimento implements EfdBlockPart {

    private final String register = "D010";
    private Number cnpj;
    private final List<AquisicaoServicoTransporte> aquisicaoServicoTransporteList;
    private final List<ResumoEscrituracaoDiaria> resumoEscrituracaoDiarias;
    private final List<ResumoEscrituracaoDiariaBilhetes> resumoEscrituracaoDiariaBilhetes;
    private final List<ResumoDiarioCupomFiscalEcf> resumoDiarioCupomFiscalEcfs;
    private final List<NfsComunicacao> nfsComunicacaos;
    private final ConsolidacaoPrestacaoServico consolidacaoPrestacaoServico;

    public IdentificacaoEstabelecimento() {
        this.aquisicaoServicoTransporteList = new ArrayList<>(1);
        this.resumoEscrituracaoDiarias = new ArrayList<>(1);
        this.resumoEscrituracaoDiariaBilhetes = new ArrayList<>(1);
        this.resumoDiarioCupomFiscalEcfs = new ArrayList<>(1);
        this.nfsComunicacaos = new ArrayList<>(1);
        this.consolidacaoPrestacaoServico = new ConsolidacaoPrestacaoServico();
    }

    @Override
    public void setByLine(final List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "D100", aquisicaoServicoTransporteList, AquisicaoServicoTransporte.class, Set.of("D100", "D101", "D105", "D111"));
        setPartListByBlock(blockLines, "D200", resumoEscrituracaoDiarias, ResumoEscrituracaoDiaria.class, Set.of("D200", "D201", "D205", "D209"));
        setPartListByBlock(blockLines, "D300", resumoEscrituracaoDiariaBilhetes, ResumoEscrituracaoDiariaBilhetes.class, Set.of("D300", "D309"));
        setPartListByBlock(blockLines, "D350", resumoDiarioCupomFiscalEcfs, ResumoDiarioCupomFiscalEcf.class, Set.of("D350", "D359"));
        setPartListByBlock(blockLines, "D500", nfsComunicacaos, NfsComunicacao.class, Set.of("D500", "D501", "D505", "D509"));
        consolidacaoPrestacaoServico.setByLine(blockLines);
    }
}
