package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro C180: Consolidação de Notas Fiscais Eletrônicas Emitidas Pela Pessoa Jurídica (Códigos 55 e 65) – Operações de Vendas.
 */
@Data
public class ConsolidacaoNfeEmitidasPj implements EfdBlockPart {

    private final String register = "C180";
    /**
     * Texto fixo contendo "55" ou “65”(Código da NF-e ou da NFC-e, conforme a Tabela 4.1.1).
     */
    private String codMod;
    private LocalDate dtDocIni;
    private LocalDate dtDocFin;
    private String codItem;
    private String codNcm;
    private String exIpi;
    private BigDecimal vlTotItem;
    private final List<OperacaoVendasPisPasep> operacoesImportacaos;
    private final List<OperacaoVendasCofins> operacaoVendasCofins;
    private final List<OperacaoVendasProcReferenciado> operacaoVendasProcReferenciados;

    public ConsolidacaoNfeEmitidasPj() {
        operacoesImportacaos = new ArrayList<>(1);
        operacaoVendasCofins = new ArrayList<>(1);
        operacaoVendasProcReferenciados = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "C181", operacoesImportacaos, OperacaoVendasPisPasep.class);
        setPartListByBlock(blockLines, "C185", operacaoVendasCofins, OperacaoVendasCofins.class);
        setPartListByBlock(blockLines, "C188", operacaoVendasProcReferenciados, OperacaoVendasProcReferenciado.class);
    }
}
