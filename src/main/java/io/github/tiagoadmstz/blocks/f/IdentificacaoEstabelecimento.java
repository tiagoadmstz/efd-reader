package io.github.tiagoadmstz.blocks.f;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Registro F010: Identificação do Estabelecimento.
 */
@Data
public class IdentificacaoEstabelecimento implements EfdBlockPart {

    private final String register = "F010";
    private Number cnpj;
    private final List<DocOpGeradorasContrCred> docOpGeradorasContrCreds;
    private final List<BensIncorporadosAtivoImobilizado> bensIncorporadosAtivoImobilizados;
    private final List<BensIncorporadosAtivoImobValorAquisicao> bensIncorporadosAtivoImobValorAquisicaos;
    private final List<CreditoPresumidoEstoqueAbertura> creditoPresumidoEstoqueAberturas;
    private final List<OpAtividadeImobUnidadeImobVendida> opAtividadeImobUnidadeImobVendidas;
    private final List<IncidPisCofinsRegimeCaixa> incidPisCofinsRegimeCaixas;
    private final List<ApContribUnidMedidaProdutoAliquotaReais> apContribUnidMedidaProdutoAliquotaReais;
    private final List<DetalhamentoReceitaRecebidaRegimeCaixa> detalhamentoReceitaRecebidaRegimeCaixas;
    private final List<BaseLucroPresIncPisCofinsRegCompet> baseLucroPresIncPisCofinsRegCompets;
    private final List<ConsOpPjSubTribBasePresIncPisCofins> consOpPjSubTribBasePresIncPisCofins;
    private final List<ContribuicaoRetidaFonte> contribuicaoRetidaFontes;
    private final List<DeducoesDiversas> deducoesDiversas;
    private final List<CredDecEventosIncorporacaoFusaoCisao> credDecEventosIncorporacaoFusaoCisaos;

    public IdentificacaoEstabelecimento() {
        this.docOpGeradorasContrCreds = new ArrayList<>(1);
        this.bensIncorporadosAtivoImobilizados = new ArrayList<>(1);
        this.bensIncorporadosAtivoImobValorAquisicaos = new ArrayList<>(1);
        this.creditoPresumidoEstoqueAberturas = new ArrayList<>(1);
        this.opAtividadeImobUnidadeImobVendidas = new ArrayList<>(1);
        this.incidPisCofinsRegimeCaixas = new ArrayList<>(1);
        this.apContribUnidMedidaProdutoAliquotaReais = new ArrayList<>(1);
        this.baseLucroPresIncPisCofinsRegCompets = new ArrayList<>(1);
        this.detalhamentoReceitaRecebidaRegimeCaixas = new ArrayList<>(1);
        this.consOpPjSubTribBasePresIncPisCofins = new ArrayList<>(1);
        this.contribuicaoRetidaFontes = new ArrayList<>(1);
        this.deducoesDiversas = new ArrayList<>(1);
        this.credDecEventosIncorporacaoFusaoCisaos = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "F100", docOpGeradorasContrCreds, DocOpGeradorasContrCred.class);
        setPartListByBlock(blockLines, "F120", bensIncorporadosAtivoImobilizados, BensIncorporadosAtivoImobilizado.class);
        setPartListByBlock(blockLines, "F130", bensIncorporadosAtivoImobValorAquisicaos, BensIncorporadosAtivoImobValorAquisicao.class);
        setPartListByBlock(blockLines, "F150", creditoPresumidoEstoqueAberturas, CreditoPresumidoEstoqueAbertura.class);
        setPartListByBlock(blockLines, "F200", opAtividadeImobUnidadeImobVendidas, OpAtividadeImobUnidadeImobVendida.class);
        setPartListByBlock(blockLines, "F500", incidPisCofinsRegimeCaixas, IncidPisCofinsRegimeCaixa.class);
        setPartListByBlock(blockLines, "F510", apContribUnidMedidaProdutoAliquotaReais, ApContribUnidMedidaProdutoAliquotaReais.class);
        setPartListByBlock(blockLines, "F525", detalhamentoReceitaRecebidaRegimeCaixas, DetalhamentoReceitaRecebidaRegimeCaixa.class);
        setPartListByBlock(blockLines, "F550", baseLucroPresIncPisCofinsRegCompets, BaseLucroPresIncPisCofinsRegCompet.class);
        setPartListByBlock(blockLines, "F560", consOpPjSubTribBasePresIncPisCofins, ConsOpPjSubTribBasePresIncPisCofins.class);
        setPartListByBlock(blockLines, "F600", contribuicaoRetidaFontes, ContribuicaoRetidaFonte.class);
        setPartListByBlock(blockLines, "F700", deducoesDiversas, DeducoesDiversas.class);
        setPartListByBlock(blockLines, "F800", credDecEventosIncorporacaoFusaoCisaos, CredDecEventosIncorporacaoFusaoCisao.class);
    }
}
