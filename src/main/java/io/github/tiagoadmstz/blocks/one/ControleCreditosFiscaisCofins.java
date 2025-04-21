package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Registro 1500: Controle de Créditos Fiscais – COFINS.
 */
@Data
public class ControleCreditosFiscaisCofins implements EfdBlockPart {

    private final String register = "1500";
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
    private final List<ApuracaoCrediExtempDocOpCofins> apuracaoCrediExtempDocOpCofins;

    public ControleCreditosFiscaisCofins() {
        this.apuracaoCrediExtempDocOpCofins = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "1501", apuracaoCrediExtempDocOpCofins, ApuracaoCrediExtempDocOpCofins.class, Set.of("1501", "1502"));
    }
}
