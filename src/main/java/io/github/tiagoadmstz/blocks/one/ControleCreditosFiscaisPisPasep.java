package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Registro 1100: Controle de Créditos Fiscais – PIS/PASEP.
 */
@Data
public class ControleCreditosFiscaisPisPasep implements EfdBlockPart {

    private final String register = "1100";
    private String perApuCred;
    private String origCred;
    private String cnpjSuc;
    private String codCred;
    private BigDecimal vlCredApu;
    private BigDecimal vlCredExtApu;
    private BigDecimal vlTotCredApu;
    private BigDecimal vlCredDescPaAnt;
    private BigDecimal vlCredPerPaAnt;
    private BigDecimal vlCredDcompPaAnt;
    private BigDecimal sdCredDispEfd;
    private BigDecimal vlCredDescEfd;
    private BigDecimal vlCredPerEfd;
    private BigDecimal vlCredDcompEfd;
    private BigDecimal vlCredTrans;
    private BigDecimal vlCredOut;
    private BigDecimal sldCredFim;
    private List<ApuracaoCredExtemporaneoDocOpPis> apuracaoCredExtemporaneoDocOpPis;

    public ControleCreditosFiscaisPisPasep() {
        this.apuracaoCredExtemporaneoDocOpPis = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "1101", apuracaoCredExtemporaneoDocOpPis, ApuracaoCredExtemporaneoDocOpPis.class, Set.of("1101", "1102"));
    }
}
