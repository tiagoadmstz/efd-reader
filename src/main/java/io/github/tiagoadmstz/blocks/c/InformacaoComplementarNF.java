package io.github.tiagoadmstz.blocks.c;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro C110: Complemento do Documento - Informação Complementar da Nota Fiscal (Códigos 01, 1B, 04 e 55) da EFD-Contribuições.
 */
@Data
public class InformacaoComplementarNF implements EfdBlockPart {

    private final String register = "C110";
    private String codInf;
    private String txtCompl;
}
