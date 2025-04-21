package io.github.tiagoadmstz.blocks.p;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro P110: Complemento da Escrituração – Detalhamento da Apuração da Contribuição.
 */
@Data
public class CompEscrDetApuracaoContribuicao implements EfdBlockPart {

    private final String register = "P110";
    private String numCampo;
    private String codDet;
    private String detValor;
    private String infCompl;
}
