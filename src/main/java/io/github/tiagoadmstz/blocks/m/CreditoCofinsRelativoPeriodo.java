package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Registro M500: Crédito de COFINS Relativo ao Período.
 */
@Data
public class CreditoCofinsRelativoPeriodo implements EfdBlockPart {

    private final String register = "M500";
    private String codCred;
    /**
     * Indicador de Crédito Oriundo de:
     * 0 – Operações próprias;
     * 1 – Evento de incorporação, cisão ou fusão.
     */
    private Integer indCredOri;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal quantBcCofins;
    private BigDecimal aliqCofinsQuant;
    private BigDecimal vlCred;
    private BigDecimal vlAjusAcres;
    private BigDecimal vlAjusReduc;
    private BigDecimal vlCredDifer;
    private BigDecimal vlCredDisp;
    /**
     * Indicador de utilização do crédito disponível no período:
     * 0 – Utilização do valor total para desconto da contribuição apurada no período, no Registro M600;
     * 1 – Utilização de valor parcial para desconto da contribuição apurada no período, no Registro M600.
     */
    private Integer indDescCred;
    /**
     * Valor do Crédito disponível, descontado da contribuição apurada no próprio período.
     * Se IND_DESC_CRED=0, informar o valor total do Campo 12;
     * Se IND_DESC_CRED=1, informar o valor parcial do Campo 12.
     */
    private BigDecimal vlCredDesc;
    private BigDecimal sldCred;
    private final List<DetalhamBaseCalculoCreditoCofins> detalhamBaseCalculoCreditoCofins;
    private final List<AjustesCreditoCofinsApurado> ajustesCreditoCofinsApurados;

    public CreditoCofinsRelativoPeriodo() {
        this.detalhamBaseCalculoCreditoCofins = new ArrayList<>(1);
        this.ajustesCreditoCofinsApurados = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "M505", detalhamBaseCalculoCreditoCofins, DetalhamBaseCalculoCreditoCofins.class);
        setPartListByBlock(blockLines, "M510", ajustesCreditoCofinsApurados, AjustesCreditoCofinsApurado.class, Set.of("M515"));
    }
}
