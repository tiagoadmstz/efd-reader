package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro M100: Crédito de PIS/PASEP Relativo ao Período.
 */
@Data
public class CreditoPisPasepRelativoPeriodo implements EfdBlockPart {

    private final String register = "M100";
    private String codCred;
    /**
     * Indicador de Crédito Oriundo de:
     * 0 – Operações próprias;
     * 1 – Evento de incorporação, cisão ou fusão.
     */
    private String indCredOri;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal quantBcPis;
    private BigDecimal aliqPisQuant;
    private BigDecimal vlCred;
    private BigDecimal vlAjusAcres;
    private BigDecimal vlAjusReduc;
    private BigDecimal vlCredDif;
    private BigDecimal vlCredDisp;
    /**
     * Indicador de opção de utilização do crédito disponível no período:
     * 0 – Utilização do valor total para desconto da contribuição apurada no período, no Registro M200;
     * 1 – Utilização de valor parcial para desconto da contribuição apurada no período, no Registro M200.
     */
    private String indDescCred;
    /**
     * Valor do Crédito disponível, descontado da contribuição apurada no próprio período.
     * Se IND_DESC_CRED=0, informar o valor total do Campo 12;
     * Se IND_DESC_CRED=1, informar o valor parcial do Campo 12.
     */
    private BigDecimal vlCredDesc;
    private BigDecimal sldCred;
    private final List<DetBaseCalculoCredApuradoPisPasep> detalhamReceitasIsentasContribZeroPisPasep;
    private final List<AjustesCreditoPisPasepApurado> ajustesCreditoPisPasepApurados;

    public CreditoPisPasepRelativoPeriodo() {
        this.detalhamReceitasIsentasContribZeroPisPasep = new ArrayList<>(1);
        this.ajustesCreditoPisPasepApurados = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "M105", detalhamReceitasIsentasContribZeroPisPasep, DetBaseCalculoCredApuradoPisPasep.class);
        setPartListByBlock(blockLines, "M110", ajustesCreditoPisPasepApurados, AjustesCreditoPisPasepApurado.class);
    }
}
