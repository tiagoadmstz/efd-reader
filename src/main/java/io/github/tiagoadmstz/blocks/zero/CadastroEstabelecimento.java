package io.github.tiagoadmstz.blocks.zero;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Registo 140: Tabela de Cadastro de Estabelecimentos
 */
@Data
public class CadastroEstabelecimento implements EfdBlockPart {

    private final String register = "0140";
    private String codEst;
    private String nome;
    private Number cnpj;
    private String uf;
    private String ie;
    private Number codMun;
    private String im;
    private String suframa;
    private RegimeApuracaoCPSRB regimeApuracaoCPSRB;
    private List<CadastroParticipante> cadastroParticipantes;
    private List<IdentificacaoUnidadesMedida> identificacaoUnidadesMedidas;
    private List<IdentificacaoItem> identificacaoItems;
    private List<InformacaoItemNotaFiscal> informacaoItemNotaFiscals;
    private List<InformacaoComplementarDocFiscal> informacaoComplementarDocFiscals;

    public CadastroEstabelecimento() {
        this.regimeApuracaoCPSRB = new RegimeApuracaoCPSRB();
        this.cadastroParticipantes = new ArrayList<>(1);
        this.identificacaoUnidadesMedidas = new ArrayList<>(1);
        this.identificacaoItems = new ArrayList<>(1);
        this.informacaoItemNotaFiscals = new ArrayList<>(1);
        this.informacaoComplementarDocFiscals = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        regimeApuracaoCPSRB.setByLine(blockLines);
        setPartListByBlock(blockLines, "0150", cadastroParticipantes, CadastroParticipante.class);
        setPartListByBlock(blockLines, "0190", identificacaoUnidadesMedidas, IdentificacaoUnidadesMedida.class);
        final Set<String> childRegisters = Set.of("0200", "0205", "0206", "0208");
        setPartListByBlock(blockLines, "0200", identificacaoItems, IdentificacaoItem.class, childRegisters);
        setPartListByBlock(blockLines, "0400", informacaoItemNotaFiscals, InformacaoItemNotaFiscal.class);
        setPartListByBlock(blockLines, "0450", informacaoComplementarDocFiscals, InformacaoComplementarDocFiscal.class);
    }
}
