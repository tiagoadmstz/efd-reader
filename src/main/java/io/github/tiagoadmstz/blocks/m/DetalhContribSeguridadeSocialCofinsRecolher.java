package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Registro M610: Detalhamento da Contribuição para a Seguridade Social - Cofins do Período.
 */
@Data
public class DetalhContribSeguridadeSocialCofinsRecolher implements EfdBlockPart {

    private final String register = "M610";
    private String codCont;
    private BigDecimal vlRecBrt;
    private BigDecimal vlBcCont;
    private BigDecimal aliqCofins;
    private BigDecimal quantBcCofins;
    private BigDecimal aliqCofinsQuant;
    private BigDecimal vlContApur;
    private BigDecimal vlAjusAcres;
    private BigDecimal vlAjusReduc;
    private BigDecimal vlContDifer;
    private BigDecimal vlContDiferAnt;
    private BigDecimal vlContPer;
    private BigDecimal vlContPer2;
    private BigDecimal vlContPer3;
    private BigDecimal vlContPer4;
    private final SociedadesCooperativasCompCalculoCofins sociedadesCooperativasCompCalculoCofins;
    private final List<DetalhAjustesCalculoMensalCofinsApurada> detalhAjustesCalculoMensalCofinsApuradas;
    private final List<AjustesCofinsApurada> ajustesCofinsApuradas;
    private final List<ConsContribSeguridadeSocialCofinsInfoAdic> consContribSeguridadeSocialCofinsInfoAdics;

    public DetalhContribSeguridadeSocialCofinsRecolher() {
        this.sociedadesCooperativasCompCalculoCofins = new SociedadesCooperativasCompCalculoCofins();
        this.detalhAjustesCalculoMensalCofinsApuradas = new ArrayList<>(1);
        this.ajustesCofinsApuradas = new ArrayList<>(1);
        this.consContribSeguridadeSocialCofinsInfoAdics = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        sociedadesCooperativasCompCalculoCofins.setByLine(blockLines);
        setPartListByBlock(blockLines, "M615", detalhAjustesCalculoMensalCofinsApuradas, DetalhAjustesCalculoMensalCofinsApurada.class);
        setPartListByBlock(blockLines, "M620", ajustesCofinsApuradas, AjustesCofinsApurada.class, Set.of("M625"));
        setPartListByBlock(blockLines, "M630", consContribSeguridadeSocialCofinsInfoAdics, ConsContribSeguridadeSocialCofinsInfoAdic.class);
    }
}
