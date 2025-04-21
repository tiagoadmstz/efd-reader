package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro C395: Detalhamento da Consolidação – Cofins.
 */
@Data
public class NotaVendaConsumidorEntradasCredito implements EfdBlockPart {

    private final String register = "C395";
    private String codMod;
    private String codPart;
    private String ser;
    private String subSer;
    private String numDoc;
    private LocalDate dtDoc;
    private BigDecimal vlDoc;
    private final List<ItensDocumentoEntradaCredito> itensDocumentoEntradaCreditos;

    public NotaVendaConsumidorEntradasCredito() {
        this.itensDocumentoEntradaCreditos = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "C396", itensDocumentoEntradaCreditos, ItensDocumentoEntradaCredito.class);
    }
}
