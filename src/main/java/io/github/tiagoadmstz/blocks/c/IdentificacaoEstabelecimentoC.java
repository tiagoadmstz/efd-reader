package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Registro C010: Identificação do Estabelecimento.
 */
@Data
public class IdentificacaoEstabelecimentoC implements EfdBlockPart {

    private final String register = "C010";
    private Number cnpj;
    /**
     * Indicador da apuração das contribuições e créditos, na escrituração das operações por NF-e e ECF, no período:
     * 1 – Apuração com base nos registros de consolidação das operações por NF-e (C180 e C190) e por ECF (C490);
     * 2 – Apuração com base no registro individualizado de NF-e (C100 e C170) e de ECF (C400).
     */
    private String indEscri;
    private final List<NotaFiscal> notaFiscais;
    private final List<ConsolidacaoNfeEmitidasPj> consolidacaoNfeEmitidasPjs;
    private final List<OperacoesAquisicao> operacoesAquisicaos;
    private final List<NotaVendaConsumidor> notaVendaConsumidors;
    private final List<NotaVendaConsumidorEntradasCredito> notaVendaConsumidorEntradasCreditos;
    private final List<EquiapmentoEcf> equiapmentoEcfs;
    private final List<ConsolidacaoDocEmitidosEcf> consolidacaoDocEmitidosEcfs;
    private final List<NotaFiscalConsumo> notaFiscalConsumos;
    private final List<ConsolidacaoDiariaNotas> consolidacaoDiariaNotas;
    private final List<CupomFiscalEletronico> cupomFiscalEletronicos;
    private final List<IdentificacaoEquipaentoSatCfe> identificacaoEquipaentoSatCfes;

    public IdentificacaoEstabelecimentoC() {
        this.notaFiscais = new ArrayList<>(1);
        this.consolidacaoNfeEmitidasPjs = new ArrayList<>(1);
        this.operacoesAquisicaos = new ArrayList<>(1);
        this.notaVendaConsumidors = new ArrayList<>(1);
        this.notaVendaConsumidorEntradasCreditos = new ArrayList<>(1);
        this.equiapmentoEcfs = new ArrayList<>(1);
        this.consolidacaoDocEmitidosEcfs = new ArrayList<>(1);
        this.notaFiscalConsumos = new ArrayList<>(1);
        this.consolidacaoDiariaNotas = new ArrayList<>(1);
        this.cupomFiscalEletronicos = new ArrayList<>(1);
        this.identificacaoEquipaentoSatCfes = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        final Set<String> childRegisters = Set.of("C100", "C111", "C120", "C170", "C175");
        setPartListByBlock(blockLines, "C100", notaFiscais, NotaFiscal.class, childRegisters);
    }
}
