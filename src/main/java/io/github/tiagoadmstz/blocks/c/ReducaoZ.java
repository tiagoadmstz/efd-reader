package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro C405: Redução Z (Códigos 02 e 2D).
 */
@Data
public class ReducaoZ implements EfdBlockPart {

    private final String register = "C405";
    private LocalDate dtDoc;
    private Number cro;
    private Number crz;
    private Number numCodFin;
    private BigDecimal gtFin;
    private BigDecimal vlBrt;
    private final List<ResumoDiarioPis> resumoDiarioPis;
    private final List<ResumoDiarioCofins> resumoDiarioCofins;

    public ReducaoZ() {
        this.resumoDiarioPis = new ArrayList<>(1);
        this.resumoDiarioCofins = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "C481", resumoDiarioPis, ResumoDiarioPis.class);
        setPartListByBlock(blockLines, "C485", resumoDiarioCofins, ResumoDiarioCofins.class);
    }
}
