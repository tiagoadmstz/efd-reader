package io.github.tiagoadmstz.blocks.a;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro A110: Complemento do Documento - Informação Complementar da NF.
 */
@Data
public class InformacaoComplementarNF implements EfdBlockPart {

    private final String register = "A110";
    private String codInf;
    private String txtCompl;
}
