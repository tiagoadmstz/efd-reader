package io.github.tiagoadmstz.blocks.d;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro D500: Nota Fiscal de Serviço de Comunicação (Código 21) e Nota Fiscal de Serviço de Telecomunicação (Código 22) – Documentos de Aquisição com Direito a Crédito.
 */
@Data
public class NfsComunicacao implements EfdBlockPart {

    private final String register = "D500";
    private String indOper;
    private String indEmit;
    private String codPart;
    private String codMod;
    private Number codSit;
    private String ser;
    private Number sub;
    private Number numDoc;
    private LocalDate dtDoc;
    private LocalDate dtAP;
    private BigDecimal vlDoc;
    private BigDecimal vlDesc;
    private BigDecimal vlServ;
    private BigDecimal vlServNt;
    private BigDecimal vlTerc;
    private BigDecimal vlDa;
    private BigDecimal vlBcIcms;
    private BigDecimal vlIcms;
    private String codInf;
    private BigDecimal vlPis;
    private BigDecimal vlCofins;
    private final List<ComplementoOperacaoPisPasep> complementoOperacaoPisPaseps;
    private final List<ComplementoOperacaoCofins> complementoOperacaoCofins;
    private final List<NfsComunicacaoProcRef> nfsComunicacaoProcRefs;

    public NfsComunicacao() {
        this.complementoOperacaoPisPaseps = new ArrayList<>(1);
        this.complementoOperacaoCofins = new ArrayList<>(1);
        this.nfsComunicacaoProcRefs = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "D501", complementoOperacaoPisPaseps, ComplementoOperacaoPisPasep.class);
        setPartListByBlock(blockLines, "D505", complementoOperacaoCofins, ComplementoOperacaoCofins.class);
        setPartListByBlock(blockLines, "D509", nfsComunicacaoProcRefs, NfsComunicacaoProcRef.class);
    }
}
