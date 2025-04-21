package io.github.tiagoadmstz.blocks.zero;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro 0450: Tabela de Informação Complementar do Documento Fiscal
 */
@Data
public class InformacaoComplementarDocFiscal implements EfdBlockPart {

    private final String reg = "0450";
    private String codInf;
    private String txt;
}
