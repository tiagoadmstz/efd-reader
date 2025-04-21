package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro 1200: Contribuição Social Extemporânea – PIS/PASEP.
 */
@Data
public class ContribuicaoSocialExtemporaneaPisPasep implements EfdBlockPart {

    private final String register = "1200";
    private String perApurAnt;
    private String natContRec;
    private BigDecimal vlContApur;
    private BigDecimal vlCredPisDesc;
    private BigDecimal vlContDev;
    private BigDecimal vlOutDed;
    private BigDecimal vlContExt;
    private BigDecimal vlMul;
    private BigDecimal vlJur;
    private String dtRecol;
    private final List<DetalhamentoContribSocialExtempPisPasep> detalhamentoContribSocialExtempPisPaseps;
    private final List<DemCredDescontarContribExtempPisPasep> demCredDescontarContribExtempPisPaseps;

    public ContribuicaoSocialExtemporaneaPisPasep() {
        this.detalhamentoContribSocialExtempPisPaseps = new ArrayList<>(1);
        this.demCredDescontarContribExtempPisPaseps = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "1210", detalhamentoContribSocialExtempPisPaseps, DetalhamentoContribSocialExtempPisPasep.class);
        setPartListByBlock(blockLines, "1220", demCredDescontarContribExtempPisPaseps, DemCredDescontarContribExtempPisPasep.class);
    }
}
