package io.github.tiagoadmstz.blocks.zero;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.List;

/**
 * Registro 0110: Regimes de Apuração da Contribuição Social e de Apropriação de Crédito
 */
@Data
public class RegimesApuracaoContribuicaoSocial implements EfdBlockPart {

    private String register = "0110";
    /**
     * Código indicador da incidência tributária no período:
     * 1 – Escrituração de operações com incidência exclusivamente no regime não-cumulativo;
     * 2 – Escrituração de operações com incidência exclusivamente no regime cumulativo;
     * 3 – Escrituração de operações com incidência nos regimes não-cumulativo e cumulativo.
     */
    private Number codIncTirb;
    /**
     * Código indicador de método de apropriação de créditos comuns, no caso de incidência no regime não-cumulativo (COD_INC_TRIB = 1 ou 3):
     * 1 – Método de Apropriação Direta;
     * 2 – Método de Rateio Proporcional (Receita Bruta)
     */
    private Number indAprovCred;
    /**
     * Código indicador do Tipo de Contribuição Apurada no Período
     * 1 – Apuração da Contribuição Exclusivamente a Alíquota Básica
     * 2 – Apuração da Contribuição a Alíquotas Específicas (Diferenciadas e/ou por Unidade de Medida de Produto)
     */
    private Number codTipoCont;
    /**
     * Código indicador do critério de escrituração e apuração adotado, no caso de incidência exclusivamente no regime cumulativo (COD_INC_TRIB = 2), pela pessoa jurídica submetida ao regime de tributação com base no lucro presumido:
     * 1 – Regime de Caixa – Escrituração consolidada (Registro F500);
     * 2 – Regime de Competência - Escrituração consolidada (Registro F550);
     * 9 – Regime de Competência - Escrituração detalhada, com base nos registros dos Blocos “A”, “C”, “D” e “F”.
     */
    private Number indRegCum;
    /**
     * O (se no registro 0110 o Campo “COD_INC_TRIB” = 1 ou 3 e o Campo “IND_APRO_CRED” = 2) N (se no registro 0110 o Campo “COD_INC_TRIB” = 2 ou o Campo “IND_APRO_CRED” = 1)
     */
    private final ReceitaBrutaMensal receitaBrutaMensal;

    public RegimesApuracaoContribuicaoSocial() {
        this.receitaBrutaMensal = new ReceitaBrutaMensal();
    }

    @Override
    public void setByLine(String valuesLine) {
        final String[] values = splitLine(valuesLine);
        codIncTirb = parseNumber(values[2]);
        indAprovCred = parseNumber(values[3]);
        codTipoCont = parseNumber(values[4]);
        if (values.length >= 6) indRegCum = parseNumber(values[5]);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        final List<String> valuesLine = getValuesLine(blockLines, register);
        if (!valuesLine.isEmpty()) setByLine(valuesLine.getFirst());
        receitaBrutaMensal.setByLine(blockLines);
    }
}
