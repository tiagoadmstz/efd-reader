package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Registro M210: Detalhamento da Contribuição para o PIS/PASEP do Período.
 */
@Data
public class DetalhamentoContribPisPeriodo implements EfdBlockPart {

    private final String register = "M210";
    private String codCont;
    private BigDecimal vlRecBrt;
    private BigDecimal vlBcCont;
    private BigDecimal aliqPis;
    private BigDecimal quantBcPis;
    private BigDecimal aliqPisQuant;
    private BigDecimal vlContApur;
    private BigDecimal vlAjusAcres;
    private BigDecimal vlAjusReduc;
    private BigDecimal vlContDifer;
    private BigDecimal vlContDiferAnt;
    private BigDecimal vlContPer;
    private final SociedadesCooperativasCompCalculoPis sociedadesCooperativasCompCalculoPis;
    private final List<AjustesCalculoContribPisApurada> ajustesCalculoContribPisApuradas;
    private final List<AjustesContribuicaoPisApurada> ajustesContribuicaoPisApuradas;
    private final List<InformacoesAdicionaisDiferimento> informacoesAdicionaisDiferimentos;

    public DetalhamentoContribPisPeriodo() {
        this.sociedadesCooperativasCompCalculoPis = new SociedadesCooperativasCompCalculoPis();
        this.ajustesCalculoContribPisApuradas = new ArrayList<>(1);
        this.ajustesContribuicaoPisApuradas = new ArrayList<>(1);
        this.informacoesAdicionaisDiferimentos = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        sociedadesCooperativasCompCalculoPis.setByLine(blockLines);
        setPartListByBlock(blockLines, "M215", ajustesCalculoContribPisApuradas, AjustesCalculoContribPisApurada.class);
        setPartListByBlock(blockLines, "M220", ajustesContribuicaoPisApuradas, AjustesContribuicaoPisApurada.class, Set.of("M225"));
        setPartListByBlock(blockLines, "M230", informacoesAdicionaisDiferimentos, InformacoesAdicionaisDiferimento.class);
    }
}
