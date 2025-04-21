package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Registro 1501: Apuração de Crédito Extemporâneo - Documentos e Operações de Períodos Anteriores – COFINS.
 */
@Data
public class ApuracaoCrediExtempDocOpCofins implements EfdBlockPart {

    private final String register = "1501";
    private String codPart;
    private String codItem;
    private String codMod;
    private String ser;
    private String subSer;
    private Integer numDoc;
    private String dtOper;
    private String chvNfe;
    private BigDecimal vlOper;
    private String cfop;
    private String natBcCred;
    private String indOrigCred;
    private String cstCofins;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCofins;
    private String codCta;
    private String codCcus;
    private String descCompl;
    private String perEscrit;
    private String cnpj;
    private final DetCredExtempVincTipoReceitaCofins detCredExtempVincTipoReceitaCofins;

    public ApuracaoCrediExtempDocOpCofins() {
        this.detCredExtempVincTipoReceitaCofins = new DetCredExtempVincTipoReceitaCofins();
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        detCredExtempVincTipoReceitaCofins.setByLine(blockLines);
    }
}
