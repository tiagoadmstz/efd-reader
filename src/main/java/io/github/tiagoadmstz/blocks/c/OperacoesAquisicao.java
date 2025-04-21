package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Registro C190: Consolidação de Notas Fiscais Eletrônicas (Código 55) – Operações de Aquisição com Direito a Crédito, e Operações de Devolução de Compras e Vendas.
 */
@Data
public class OperacoesAquisicao implements EfdBlockPart {

    private final String register = "C190";
    /**
     * Texto fixo contendo "55" (Código da Nota Fiscal Eletrônica, modelo 55, conforme a Tabela 4.1.1).
     */
    private String codMod = "55";
    private LocalDate dtDocIni;
    private LocalDate dtDocFin;
    private String codItem;
    private String codNcm;
    private String exIpi;
    private BigDecimal vlTotItem;
    private final List<OperacaoAquisicaoPisPasep> operacaoAquisicaoPisPaseps;
    private final List<OperacaoAquisicaoCofins> operacaoAquisicaoCofins;
    private final List<OperacaoAquisicaoProcReferenciado> operacaoAquisicaoProcReferenciados;
    private final List<OperacaoImportacaoCompl> operacaoImportacaoComplList;

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "C191", operacaoAquisicaoPisPaseps, OperacaoAquisicaoPisPasep.class);
        setPartListByBlock(blockLines, "C195", operacaoAquisicaoCofins, OperacaoAquisicaoCofins.class);
        setPartListByBlock(blockLines, "C198", operacaoAquisicaoProcReferenciados, OperacaoAquisicaoProcReferenciado.class);
        setPartListByBlock(blockLines, "C199", operacaoImportacaoComplList, OperacaoImportacaoCompl.class);
    }
}
