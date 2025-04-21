package io.github.tiagoadmstz.blocks;

import io.github.tiagoadmstz.blocks.one.AberturaBlocoOne;
import io.github.tiagoadmstz.blocks.one.ConsDocEmitidosPjSubRegTribLucroPresumido;
import io.github.tiagoadmstz.blocks.one.ContribuicaoSocialExtemporaneaCofins;
import io.github.tiagoadmstz.blocks.one.ContribuicaoSocialExtemporaneaPisPasep;
import io.github.tiagoadmstz.blocks.one.ControleCreditosFiscaisCofins;
import io.github.tiagoadmstz.blocks.one.ControleCreditosFiscaisPisPasep;
import io.github.tiagoadmstz.blocks.one.ControleValoresRetidosFonteCofins;
import io.github.tiagoadmstz.blocks.one.ControleValoresRetidosFontePisPasep;
import io.github.tiagoadmstz.blocks.one.DetAjustesBaseCalcMensalPisCofins;
import io.github.tiagoadmstz.blocks.one.EncerramentoBlocoOne;
import io.github.tiagoadmstz.blocks.one.IncorporacaoImobiliariaRet;
import io.github.tiagoadmstz.blocks.one.ProcessoReferenciadoAcaoJudicial;
import io.github.tiagoadmstz.blocks.one.ProcessoReferenciadoProcessoAdministrativo;
import io.github.tiagoadmstz.interfaces.EfdBlock;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Bloco 1: Complemento da Escrituração – Controle de Saldos de Créditos e de Retenções, Operações Extemporâneas e Outras Informações.
 */
@Data
public class BlockOne implements EfdBlock {

    private final AberturaBlocoOne aberturaBlocoOne;
    private final List<ProcessoReferenciadoAcaoJudicial> processoReferenciadoAcaoJudiciais;
    private final List<ProcessoReferenciadoProcessoAdministrativo> processoReferenciadoProcessoAdministrativos;
    private final List<DetAjustesBaseCalcMensalPisCofins> detAjustesBaseCalcMensalPisCofins;
    private final List<ControleCreditosFiscaisPisPasep> controleCreditosFiscaisPisPaseps;
    private final List<ContribuicaoSocialExtemporaneaPisPasep> contribuicaoSocialExtemporaneaPisPaseps;
    private final List<ControleValoresRetidosFontePisPasep> controleValoresRetidosFontePisPaseps;
    private final List<ControleCreditosFiscaisCofins> controleCreditosFiscaisCofins;
    private final List<ContribuicaoSocialExtemporaneaCofins> contribuicaoSocialExtemporaneaCofins;
    private final List<ControleValoresRetidosFonteCofins> controleValoresRetidosFonteCofins;
    private final List<IncorporacaoImobiliariaRet> incorporacaoImobiliariaRets;
    private final List<ConsDocEmitidosPjSubRegTribLucroPresumido> consDocEmitidosPjSubRegTribLucroPresumido;
    private final EncerramentoBlocoOne encerramentoBlocoOne;

    public BlockOne() {
        this.aberturaBlocoOne = new AberturaBlocoOne();
        this.processoReferenciadoAcaoJudiciais = new ArrayList<>(1);
        this.processoReferenciadoProcessoAdministrativos = new ArrayList<>(1);
        this.detAjustesBaseCalcMensalPisCofins = new ArrayList<>(1);
        this.controleCreditosFiscaisPisPaseps = new ArrayList<>(1);
        this.contribuicaoSocialExtemporaneaPisPaseps = new ArrayList<>(1);
        this.controleValoresRetidosFontePisPaseps = new ArrayList<>(1);
        this.controleCreditosFiscaisCofins = new ArrayList<>(1);
        this.contribuicaoSocialExtemporaneaCofins = new ArrayList<>(1);
        this.controleValoresRetidosFonteCofins = new ArrayList<>(1);
        this.incorporacaoImobiliariaRets = new ArrayList<>(1);
        this.consDocEmitidosPjSubRegTribLucroPresumido = new ArrayList<>(1);
        this.encerramentoBlocoOne = new EncerramentoBlocoOne();
    }

    public void setByLineNEW(final List<String> lines) {
        final List<String> blockLines = lines.stream()
                .filter(line -> line.startsWith("1", 1))
                .toList();
        aberturaBlocoOne.setByLine(blockLines);
        setPartListByBlock(blockLines, "1010", processoReferenciadoAcaoJudiciais, ProcessoReferenciadoAcaoJudicial.class, Set.of("1010", "1011"));
        setPartListByBlock(blockLines, "1020", processoReferenciadoProcessoAdministrativos, ProcessoReferenciadoProcessoAdministrativo.class);
        setPartListByBlock(blockLines, "1050", detAjustesBaseCalcMensalPisCofins, DetAjustesBaseCalcMensalPisCofins.class);
        setPartListByBlock(blockLines, "1100", controleCreditosFiscaisPisPaseps, ControleCreditosFiscaisPisPasep.class, Set.of("1100", "1101", "1102"));
        setPartListByBlock(blockLines, "1200", contribuicaoSocialExtemporaneaPisPaseps, ContribuicaoSocialExtemporaneaPisPasep.class, Set.of("1200", "1210", "1220"));
        setPartListByBlock(blockLines, "1300", controleValoresRetidosFontePisPaseps, ControleValoresRetidosFontePisPasep.class);
        setPartListByBlock(blockLines, "1500", controleCreditosFiscaisCofins, ControleCreditosFiscaisCofins.class, Set.of("1500", "1501", "1502"));
        setPartListByBlock(blockLines, "1600", contribuicaoSocialExtemporaneaCofins, ContribuicaoSocialExtemporaneaCofins.class, Set.of("1600", "1610", "1620"));
        setPartListByBlock(blockLines, "1700", controleValoresRetidosFonteCofins, ControleValoresRetidosFonteCofins.class);
        setPartListByBlock(blockLines, "1800", incorporacaoImobiliariaRets, IncorporacaoImobiliariaRet.class, Set.of("1809"));
        setPartListByBlock(blockLines, "1900", consDocEmitidosPjSubRegTribLucroPresumido, ConsDocEmitidosPjSubRegTribLucroPresumido.class);
        encerramentoBlocoOne.setByLine(blockLines);
    }
}
