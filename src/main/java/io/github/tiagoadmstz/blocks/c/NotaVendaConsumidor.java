package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro C380: Nota Fiscal de Venda a Consumidor (Código 02) - Consolidação de Documentos Emitidos.
 */
@Data
public class NotaVendaConsumidor implements EfdBlockPart {

    private final String register = "C380";
    private String codMod;
    private LocalDate dtDocIni;
    private LocalDate dtDocFin;
    private Number numDocIni;
    private Number numDocFin;
    private BigDecimal vlDoc;
    private BigDecimal vlDocCanc;
    private final List<DetalhamentoConsolidacaoPisPasep> detalhamentoConsolidacaoPisPaseps;
    private final List<DetalhamentoConsolidacaoCofins> detalhamentoConsolidacaoCofins;

    public NotaVendaConsumidor() {
        this.detalhamentoConsolidacaoPisPaseps = new ArrayList<>(1);
        this.detalhamentoConsolidacaoCofins = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "C381", detalhamentoConsolidacaoPisPaseps, DetalhamentoConsolidacaoPisPasep.class);
        setPartListByBlock(blockLines, "C385", detalhamentoConsolidacaoCofins, DetalhamentoConsolidacaoCofins.class);
    }
}
