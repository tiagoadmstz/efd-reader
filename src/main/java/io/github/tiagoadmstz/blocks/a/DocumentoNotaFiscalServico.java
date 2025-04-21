package io.github.tiagoadmstz.blocks.a;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro A100: Documento - Nota Fiscal de Serviço.
 */
@Data
public class DocumentoNotaFiscalServico implements EfdBlockPart {

    private final String register = "A100";
    /**
     * Indicador do tipo de operação:
     * 0 - Serviço Contratado pelo Estabelecimento;
     * 1 - Serviço Prestado pelo Estabelecimento.
     */
    private String indOper;
    /**
     * Indicador do emitente do documento fiscal:
     * 0 - Emissão Própria;
     * 1 - Emissão de Terceiros
     */
    private String indEmit;
    private String codPart;
    /**
     * Código da situação do documento fiscal:
     * 00 – Documento regular
     * 02 – Documento cancelado
     */
    private String codSit;
    private String ser;
    private String sub;
    private String numDoc;
    private String chvNfse;
    private LocalDate dtDoc;
    private LocalDate dtExeServ;
    private BigDecimal vlDoc;
    /**
     * Indicador do tipo de pagamento:
     * 0- À vista;
     * 1- A prazo;
     * 9- Sem pagamento.
     */
    private String indPgto;
    private BigDecimal vlDesc;
    private BigDecimal vlBcPis;
    private BigDecimal vlPis;
    private BigDecimal vlBcCofins;
    private BigDecimal vlCofins;
    private BigDecimal vlPisRet;
    private BigDecimal vlCofinsRet;
    private BigDecimal vlIss;
    private final List<InformacaoComplementarNF> informacaoComplementarNFs;
    private final List<ProcessoReferenciado> processoReferenciados;
    private final List<OperacoesImportacao> operacoesImportacaos;
    private final List<ComplementoDocumentoItem> complementoDocumentoItems;

    public DocumentoNotaFiscalServico() {
        informacaoComplementarNFs = new ArrayList<>(1);
        processoReferenciados = new ArrayList<>(1);
        operacoesImportacaos = new ArrayList<>(1);
        complementoDocumentoItems = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "A110", informacaoComplementarNFs, InformacaoComplementarNF.class);
        setPartListByBlock(blockLines, "A111", processoReferenciados, ProcessoReferenciado.class);
        setPartListByBlock(blockLines, "A120", operacoesImportacaos, OperacoesImportacao.class);
        setPartListByBlock(blockLines, "A170", complementoDocumentoItems, ComplementoDocumentoItem.class);
    }
}
