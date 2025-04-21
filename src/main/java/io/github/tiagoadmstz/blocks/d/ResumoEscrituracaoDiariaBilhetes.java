package io.github.tiagoadmstz.blocks.d;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro D300: Resumo da Escrituração Diária - Bilhetes Consolidados de Passagem Rodoviário (Código 13), de Passagem Aquaviário (Código 14), de Passagem e Nota de Bagagem (Código 15), de Passagem Ferroviário (Código 16) e Resumo de Movimento Diário (Código 18).
 */
@Data
public class ResumoEscrituracaoDiariaBilhetes implements EfdBlockPart {

    private final String register = "D300";
    private String codMod;
    private String ser;
    private String sub;
    private Number numDocIni;
    private Number numDocFin;
    private Number cfop;
    private LocalDate dtRef;
    private BigDecimal vlDoc;
    private BigDecimal vlDesc;
    private Number cstPis;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal vlPis;
    private Number cstCofins;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCofins;
    private String codCta;
    private final List<ResumoEscrituracaoDiariaBilhetesProcRef> resumoEscrituracaoDiariaBilhetesProcRefs;

    public ResumoEscrituracaoDiariaBilhetes() {
        this.resumoEscrituracaoDiariaBilhetesProcRefs = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "D309", resumoEscrituracaoDiariaBilhetesProcRefs, ResumoEscrituracaoDiariaBilhetesProcRef.class);
    }
}
