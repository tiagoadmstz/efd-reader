package io.github.tiagoadmstz.blocks.d;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro D350: Resumo Diário de Cupom Fiscal Emitido Por ECF - (Código: 2E, 13, 14, 15 e 16).
 */
@Data
public class ResumoDiarioCupomFiscalEcf implements EfdBlockPart {

    private final String register = "D350";
    private String codMod;
    private String ecfMod;
    private String ecfFab;
    private LocalDate dtDoc;
    private Number cro;
    private Number crz;
    private Number numCooFin;
    private BigDecimal gtFin;
    private BigDecimal vlBrt;
    private Number cstPis;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal quantBcPis;
    private BigDecimal aliqPisQuant;
    private BigDecimal vlPis;
    private Number cstCofins;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal quantBcCofins;
    private BigDecimal aliqCofinsQuant;
    private BigDecimal vlCofins;
    private String codCta;
    private final List<ResumoDiarioCupomFiscalEcfProcRef> resumoDiarioCupomFiscalEcfProcRefs;

    public ResumoDiarioCupomFiscalEcf() {
        this.resumoDiarioCupomFiscalEcfProcRefs = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "D359", resumoDiarioCupomFiscalEcfProcRefs, ResumoDiarioCupomFiscalEcfProcRef.class);
    }
}
