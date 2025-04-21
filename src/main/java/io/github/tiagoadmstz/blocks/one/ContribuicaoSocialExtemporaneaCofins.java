package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro 1600: Contribuição Social Extemporânea – COFINS
 */
@Data
public class ContribuicaoSocialExtemporaneaCofins implements EfdBlockPart {

    private final String register = "1600";
    private String perApurAnt;
    private String natContRec;
    private BigDecimal vlContApur;
    private BigDecimal vlCredCofinsDesc;
    private BigDecimal vlContDev;
    private BigDecimal vlOutDed;
    private BigDecimal vlContExt;
    private BigDecimal vlMul;
    private BigDecimal vlJur;
    private String dtRecol;
    private final List<DetContribuicaoSocialExtemporaneaCofins> detContribuicaoSocialExtemporaneaCofins;
    private final List<DemoCredDescontarContribExtempCofins> demoCredDescontarContribExtempCofins;

    public ContribuicaoSocialExtemporaneaCofins() {
        this.detContribuicaoSocialExtemporaneaCofins = new ArrayList<>(1);
        this.demoCredDescontarContribExtempCofins = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "1610", detContribuicaoSocialExtemporaneaCofins, DetContribuicaoSocialExtemporaneaCofins.class);
        setPartListByBlock(blockLines, "1620", demoCredDescontarContribExtempCofins, DemoCredDescontarContribExtempCofins.class);
    }
}
