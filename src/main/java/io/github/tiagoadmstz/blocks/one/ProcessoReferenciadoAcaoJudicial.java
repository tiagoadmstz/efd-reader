package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Registro 1010: Processo Referenciado – Ação Judicial.
 */
@Data
public class ProcessoReferenciadoAcaoJudicial implements EfdBlockPart {

    private final String register = "1010";
    private String numProc;
    private String idSecJud;
    private String idVara;
    /**
     * Indicador da Natureza da Ação Judicial, impetrada na Justiça Federal:
     * 01 – Decisão judicial transitada em julgado, a favor da pessoa jurídica.
     * 02 – Decisão judicial não transitada em julgado, a favor da pessoa jurídica.
     * 03 – Decisão judicial oriunda de liminar em mandado de segurança.
     * 04 – Decisão judicial oriunda de liminar em medida cautelar.
     * 05 – Decisão judicial oriunda de antecipação de tutela.
     * 06 - Decisão judicial vinculada a depósito administrativo ou judicial em montante integral.
     * 07 – Medida judicial em que a pessoa jurídica não é o autor.
     * 08 – Súmula vinculante aprovada pelo STF ou STJ.
     * 09 – Decisão judicial oriunda de liminar em mandado de segurança coletivo.
     * 12 – Decisão judicial não transitada em julgado, a favor da pessoa jurídica - Exigibilidade suspensa de contribuição.
     * 13 – Decisão judicial oriunda de liminar em mandado de segurança - Exigibilidade suspensa de contribuição.
     * 14 – Decisão judicial oriunda de liminar em medida cautelar - Exigibilidade suspensa de contribuição.
     * 15 – Decisão judicial oriunda de antecipação de tutela - Exigibilidade suspensa de contribuição.
     * 16 - Decisão judicial vinculada a depósito administrativo ou judicial em montante integral - Exigibilidade suspensa de contribuição.
     * 17 – Medida judicial em que a pessoa jurídica não é o autor - Exigibilidade suspensa de contribuição.
     * 19 – Decisão judicial oriunda de liminar em mandado de segurança coletivo - Exigibilidade suspensa de contribuição.
     * 99 - Outros.
     */
    private String indNatAcao;
    private String descDecJud;
    private String dtSentJud;
    private final List<DetalhamentoContribuicoesExibSuspensa> detalhamentoContribuicoesExibSuspensas;

    public ProcessoReferenciadoAcaoJudicial() {
        this.detalhamentoContribuicoesExibSuspensas = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "1011", detalhamentoContribuicoesExibSuspensas, DetalhamentoContribuicoesExibSuspensa.class);
    }
}
