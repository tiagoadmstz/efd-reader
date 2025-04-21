package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro C600: Consolidação Diária de Notas Fiscais/Contas Emitidas de Energia Elétrica (Código 06), Nota Fiscal de Energia Elétrica Eletrônica – NF3e (Código 66), Nota Fiscal/Conta de Fornecimento Dágua Canalizada (Código 29) e Nota Fiscal/Conta de Fornecimento de Gás (Código 28) (Empresas Obrigadas ou não Obrigadas ao Convenio ICMS 115/03) – Documentos de Saída.
 */
@Data
public class ConsolidacaoDiariaNotas implements EfdBlockPart {

    private final String register = "C600";
    private String codMod;
    private Number codMun;
    private String ser;
    private Number sub;
    /**
     * Código de classe de consumo de energia elétrica, conforme a Tabela 4.4.5, ou Código de Consumo de Fornecimento Dágua – Tabela 4.4.2 ou Código da classe de consumo de gás canalizado conforme Tabela 4.4.3.
     */
    private Number codCons;
    private BigDecimal qtdCons;
    private BigDecimal qtdCanc;
    private LocalDate dtDoc;
    private LocalDate vlDoc;
    private LocalDate vlDesc;
    private BigDecimal cons;
    private BigDecimal vlForn;
    private BigDecimal vlServNt;
    private BigDecimal vlTerc;
    private BigDecimal vlDa;
    private BigDecimal vlBcIcms;
    private BigDecimal vlIcms;
    private BigDecimal vlBcIcmsSt;
    private BigDecimal vlIcmsSt;
    private BigDecimal vlPis;
    private BigDecimal vlCofins;
    private final List<ComplementoConsolidacaoDiariaPis> complementoConsolidacaoDiariaPis;
    private final List<ComplementoConsolidacaoDiariaCofins> complementoConsolidacaoDiariaCofins;
    private final List<ComplementoConsolidacaoDiariaProcRef> complementoConsolidacaoDiariaProcRefs;

    public ConsolidacaoDiariaNotas() {
        this.complementoConsolidacaoDiariaPis = new ArrayList<>(1);
        this.complementoConsolidacaoDiariaCofins = new ArrayList<>(1);
        this.complementoConsolidacaoDiariaProcRefs = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "C601", complementoConsolidacaoDiariaPis, ComplementoConsolidacaoDiariaPis.class);
        setPartListByBlock(blockLines, "C605", complementoConsolidacaoDiariaCofins, ComplementoConsolidacaoDiariaCofins.class);
        setPartListByBlock(blockLines, "C609", complementoConsolidacaoDiariaProcRefs, ComplementoConsolidacaoDiariaProcRef.class);
    }
}
