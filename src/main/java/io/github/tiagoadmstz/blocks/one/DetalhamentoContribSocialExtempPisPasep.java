package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro 1210: Detalhamento da Contribuição Social Extemporânea – PIS/PASEP.
 */
@Data
public class DetalhamentoContribSocialExtempPisPasep implements EfdBlockPart {

    private final String register = "1210";
    private String cnpj;
    private String cstPis;
    private String codPart;
    private String dtOper;
    private BigDecimal vlOper;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal vlPis;
    private String codCta;
    private String descCompl;
}
