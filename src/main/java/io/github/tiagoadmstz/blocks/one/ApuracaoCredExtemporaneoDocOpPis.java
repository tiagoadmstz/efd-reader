package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro 1101: Apuração de Crédito Extemporâneo - Documentos e Operações de Períodos Anteriores – PIS/PASEP.
 */
@Data
public class ApuracaoCredExtemporaneoDocOpPis implements EfdBlockPart {

    private final String register = "1101";
    private String codPart;
    private String codItem;
    private String codMod;
    private String ser;
    private String subSer;
    private Long numDoc;
    private String dtOper;
    private String chvNfe;
    private BigDecimal vlOper;
    private String cfop;
    private String natBcCred;
    private Integer indOrigCred;
    private String cstPis;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal vlPis;
    private String codCta;
    private String codCcus;
    private String descCompl;
    private String perEscrit;
    private String cnpj;
    private List<DetCrediExtempVinculadoTipoReceitaPis> detCrediExtempVinculadoTipoReceitaPis;

    public ApuracaoCredExtemporaneoDocOpPis() {
        this.detCrediExtempVinculadoTipoReceitaPis = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "1102", detCrediExtempVinculadoTipoReceitaPis, DetCrediExtempVinculadoTipoReceitaPis.class);
    }
}
