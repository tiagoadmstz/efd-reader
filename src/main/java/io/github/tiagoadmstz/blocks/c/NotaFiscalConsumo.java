package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro C500: Nota Fiscal/Conta de Energia Elétrica (Código 06), Nota Fiscal/Conta de Fornecimento Dágua Canalizada (Código 29) e Nota Fiscal Consumo Fornecimento de Gás (Código 28) e NF-e (Código 55) – Documentos de Entrada/Aquisição com Crédito.
 */
@Data
public class NotaFiscalConsumo implements EfdBlockPart {

    private final String register = "C500";
    private String codPart;
    private String codMod;
    private Number codSit;
    private String ser;
    private Number sub;
    private Number numDoc;
    private LocalDate dtDoc;
    private LocalDate dtEnt;
    private BigDecimal vlDoc;
    private BigDecimal vlIcms;
    private String codInf;
    private BigDecimal vlPis;
    private BigDecimal vlCofins;
    private Number chvDoce;
    private final List<ComplementoOperacaoPisPasep> complementoOperacaoPisPaseps;
    private final List<ComplementoOperacaoCofins> complementoOperacaoCofins;
    private final List<ComplementoOperacaoProcRef> complementoOperacaoProcRefs;

    public NotaFiscalConsumo() {
        this.complementoOperacaoPisPaseps = new ArrayList<>(1);
        this.complementoOperacaoCofins = new ArrayList<>(1);
        this.complementoOperacaoProcRefs = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "C501", complementoOperacaoPisPaseps, ComplementoOperacaoPisPasep.class);
        setPartListByBlock(blockLines, "C505", complementoOperacaoCofins, ComplementoOperacaoCofins.class);
        setPartListByBlock(blockLines, "C509", complementoOperacaoProcRefs, ComplementoOperacaoProcRef.class);
    }
}
