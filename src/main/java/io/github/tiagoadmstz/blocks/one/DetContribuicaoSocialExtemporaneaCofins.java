package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro 1610: Detalhamento da Contribuição Social Extemporânea – Cofins.
 */
@Data
public class DetContribuicaoSocialExtemporaneaCofins implements EfdBlockPart {

    private final String register = "1610";
    private String cnpj;
    private String cstCofins;
    private String codPart;
    private String dtOper;
    private BigDecimal vlOper;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCofins;
    private String codCta;
    private String descCompl;
}
