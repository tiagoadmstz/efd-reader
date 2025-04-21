package io.github.tiagoadmstz.blocks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.inject.Inject;
import io.github.tiagoadmstz.blocks.zero.AberturaBlocoZero;
import io.github.tiagoadmstz.blocks.zero.CadastroEstabelecimento;
import io.github.tiagoadmstz.blocks.zero.CentroCustos;
import io.github.tiagoadmstz.blocks.zero.ComposicaoReceitasPeriodo;
import io.github.tiagoadmstz.blocks.zero.DadosContabilista;
import io.github.tiagoadmstz.blocks.zero.EncerramentoBloco;
import io.github.tiagoadmstz.blocks.zero.IdentificacaoScp;
import io.github.tiagoadmstz.blocks.zero.IdentificacaoSemDados;
import io.github.tiagoadmstz.blocks.zero.PlanoContasContabeis;
import io.github.tiagoadmstz.blocks.zero.RegimesApuracaoContribuicaoSocial;
import io.github.tiagoadmstz.interfaces.EfdBlock;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class BlockZero implements EfdBlock {

    @JsonProperty("block-open")
    private final AberturaBlocoZero aberturaBlocoZero;
    /**
     * O (se no registro “0000” o campo “IND_NAT_PJ” for igual a “03”, “04” ou “05”)
     */
    @JsonProperty("identificacao-scp")
    private final List<IdentificacaoScp> identificacaoScpList;
    private final DadosContabilista dadosContabilista;
    private final RegimesApuracaoContribuicaoSocial regimesApuracaoContribuicaoSocial;
    private final IdentificacaoSemDados identificacaoSemDados;
    private final List<CadastroEstabelecimento> cadastroEstabelecimentos;
    private final List<PlanoContasContabeis> planoContasContabeis;
    private final List<CentroCustos> centroCustos;
    private final ComposicaoReceitasPeriodo composicaoReceitasPeriodo;
    private final EncerramentoBloco encerramentoBloco;

    @Inject
    public BlockZero() {
        this.aberturaBlocoZero = new AberturaBlocoZero();
        this.identificacaoScpList = new ArrayList<>(1);
        this.dadosContabilista = new DadosContabilista();
        this.regimesApuracaoContribuicaoSocial = new RegimesApuracaoContribuicaoSocial();
        this.identificacaoSemDados = new IdentificacaoSemDados();
        this.cadastroEstabelecimentos = new ArrayList<>(1);
        this.planoContasContabeis = new ArrayList<>(1);
        this.centroCustos = new ArrayList<>(1);
        this.composicaoReceitasPeriodo = new ComposicaoReceitasPeriodo();
        this.encerramentoBloco = new EncerramentoBloco();
    }

    public void setByLineNEW(final List<String> lines) {
        final List<String> blockLines = lines.stream()
                .filter(line -> line.startsWith("0", 1))
                .toList();
        aberturaBlocoZero.setByLine(blockLines);
        setPartListByBlock(blockLines, "0035", identificacaoScpList, IdentificacaoScp.class);
        dadosContabilista.setByLine(blockLines);
        regimesApuracaoContribuicaoSocial.setByLine(blockLines);
        final Set<String> childRegisters = Set.of("0140", "0145", "0150", "0190", "0200", "0205", "0206", "0208", "0400", "0450");
        setPartListByBlock(blockLines, "0140", cadastroEstabelecimentos, CadastroEstabelecimento.class, childRegisters);
        setPartListByBlock(blockLines, "0500", planoContasContabeis, PlanoContasContabeis.class);
        setPartListByBlock(blockLines, "0600", centroCustos, CentroCustos.class);
        composicaoReceitasPeriodo.setByLine(blockLines);
        encerramentoBloco.setByLine(blockLines);
    }
}
