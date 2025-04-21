package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro C800: Cupom Fiscal Eletrônico (Código 59).
 */
@Data
public class CupomFiscalEletronico implements EfdBlockPart {

    private final String register = "C800";
    private String codMod;
    private Number codSit;
    private Number numCfe;
    private LocalDate dtDoc;
    private BigDecimal vlCfe;
    private BigDecimal vlPis;
    private BigDecimal vlCofins;
    private String cnpjCpf;
    private Number nrSat;
    private Number chvCfe;
    private BigDecimal vlDesc;
    private BigDecimal vlMerc;
    private BigDecimal vlOutDa;
    private BigDecimal vlIcms;
    private BigDecimal vlPisSt;
    private BigDecimal vlCofinsSt;
    private final List<DetalhamentoCfePisCofins> detalhamentoCfePisCofins;
    private final List<DetalhamentoCfePisCofinsUnid> detalhamentoCfePisCofinsUnids;
    private final List<CupomFiscalEletronicoProcRef> cupomFiscalEletronicoProcRefs;

    public CupomFiscalEletronico() {
        this.detalhamentoCfePisCofins = new ArrayList<>(1);
        this.detalhamentoCfePisCofinsUnids = new ArrayList<>(1);
        this.cupomFiscalEletronicoProcRefs = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "C810", detalhamentoCfePisCofins, DetalhamentoCfePisCofins.class);
        setPartListByBlock(blockLines, "C820", detalhamentoCfePisCofinsUnids, DetalhamentoCfePisCofinsUnid.class);
        setPartListByBlock(blockLines, "C830", cupomFiscalEletronicoProcRefs, CupomFiscalEletronicoProcRef.class);
    }
}
