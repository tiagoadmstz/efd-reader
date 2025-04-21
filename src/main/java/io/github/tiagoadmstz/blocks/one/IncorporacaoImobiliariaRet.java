package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro 1800: Incorporação Imobiliária – RET.
 */
@Data
public class IncorporacaoImobiliariaRet implements EfdBlockPart {

    private final String register = "1800";
    private String incImob;
    private BigDecimal recRecebRet;
    private BigDecimal recFinRet;
    private BigDecimal bcRet;
    private BigDecimal aliqRet;
    private BigDecimal vlRecUni;
    private String dtRecUni;
    private String codRec;
    private final List<IncorporacaoImobiliariaRetProcRef> incorporacaoImobiliariaRetProcRefs;

    public IncorporacaoImobiliariaRet() {
        this.incorporacaoImobiliariaRetProcRefs = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "1809", incorporacaoImobiliariaRetProcRefs, IncorporacaoImobiliariaRetProcRef.class);
    }
}
