package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro C100: Documento - Nota Fiscal (Código 01), Nota Fiscal Avulsa (Código 1B), Nota Fiscal de Produtor (Código 04), NF-e (Código 55) e NFC-e (Código 65).
 */
@Data
public class NotaFiscal implements EfdBlockPart {

    private final String register = "C100";
    /**
     * Indicador do tipo de operação:
     * 0- Entrada;
     * 1- Saída
     */
    private String indOper;
    /**
     * Indicador do emitente do documento fiscal:
     * 0- Emissão própria;
     * 1- Terceiros
     */
    private String indEmit;
    private String codPart;
    private String codMod;
    private String codSit;
    private String ser;
    private Number numDoc;
    private String chvNfe;
    private LocalDate dtDoc;
    private LocalDate dtES;
    private BigDecimal vlDoc;
    /**
     * Indicador do tipo de pagamento:
     * 0- À vista;
     * 1- A prazo;
     * 9- Sem pagamento.
     * ------
     * Obs.: A partir de 01/07/2012 passará a ser:
     * Indicador do tipo de pagamento:
     * 0- À vista;
     * 1- A prazo;
     * 2 - Outros
     */
    private String indPgto;
    private BigDecimal vlDesc;
    private BigDecimal vlAbatNt;
    private BigDecimal vlMerc;
    /**
     * Indicador do tipo do frete:
     * 0- Por conta de terceiros;
     * 1- Por conta do emitente;
     * 2- Por conta do destinatário;
     * 9- Sem cobrança de frete.
     * ------
     * Obs.: A partir de 01/01/2012 passará a ser:
     * Indicador do tipo do frete:
     * 0- Por conta do emitente;
     * 1- Por conta do destinatário/remetente;
     * 2- Por conta de terceiros;
     * 9- Sem cobrança de frete.
     * ------
     * Obs.: A partir de 01/10/2017 passará a ser:
     * Indicador do tipo de frete/transporte:
     * 0 - Frete por conta do remetente (CIF);
     * 1 - Frete por conta do destinatário (FOB);
     * 2 - Frete por conta de terceiros;
     * 3 – Transporte próprio por conta do remetente;
     * 4 – Transporte próprio por conta do destinatário;
     * 9 - Sem ocorrência de transporte.
     */
    private String indFrt;
    private BigDecimal vlFrt;
    private BigDecimal vlSeg;
    private BigDecimal vlOutDa;
    private BigDecimal vlBcIcms;
    private BigDecimal vlIcms;
    private BigDecimal vlBcIcmsSt;
    private BigDecimal vlIcmsSt;
    private BigDecimal vlIpi;
    private BigDecimal vlPis;
    private BigDecimal vlCofins;
    private BigDecimal vlPisSt;
    private BigDecimal vlCofinsSt;
    private final List<InformacaoComplementarNF> informacaoComplementarNFList;
    private final List<ProcessoReferenciado> processoReferenciados;
    private final List<OperacoesImportacao> operacoesImportacaos;
    private final List<ItensDocumento> itensDocumentos;
    private final List<RegistroAnaliticoDocumento> registroAnaliticoDocumentos;

    public NotaFiscal() {
        informacaoComplementarNFList = new ArrayList<>(1);
        processoReferenciados = new ArrayList<>(1);
        operacoesImportacaos = new ArrayList<>(1);
        itensDocumentos = new ArrayList<>(1);
        registroAnaliticoDocumentos = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "C110", informacaoComplementarNFList, InformacaoComplementarNF.class);
        setPartListByBlock(blockLines, "C111", processoReferenciados, ProcessoReferenciado.class);
        setPartListByBlock(blockLines, "C120", operacoesImportacaos, OperacoesImportacao.class);
        setPartListByBlock(blockLines, "C170", itensDocumentos, ItensDocumento.class);
        setPartListByBlock(blockLines, "C175", operacoesImportacaos, RegistroAnaliticoDocumento.class);
    }
}
