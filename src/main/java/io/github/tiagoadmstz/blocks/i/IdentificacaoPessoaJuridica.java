package io.github.tiagoadmstz.blocks.i;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Registro I010: Identificação da Pessoa Jurídica/Estabelecimento.
 */
@Data
public class IdentificacaoPessoaJuridica implements EfdBlockPart {

    private final String register = "I010";
    private String cnpj;
    /**
     * Indicador de operações realizadas no período:
     * 01 – Exclusivamente operações de Instituições Financeiras e Assemelhadas;
     * 02 – Exclusivamente operações de Seguros Privados;
     * 03 – Exclusivamente operações de Previdência Complementar;
     * 04 – Exclusivamente operações de Capitalização;
     * 05 – Exclusivamente operações de Planos de Assistência à Saúde;
     * 06 – Realizou operações referentes a mais de um dos indicadores acima.
     */
    private String indAtiv;
    private String infoCompl;
    private final List<ConsolidacaoOperacoesPeriodo> consolidacaoOperacoesPeriodos;

    public IdentificacaoPessoaJuridica() {
        this.consolidacaoOperacoesPeriodos = new ArrayList<>(1);
    }
}
