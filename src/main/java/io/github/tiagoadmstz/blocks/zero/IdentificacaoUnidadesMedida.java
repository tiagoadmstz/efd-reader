package io.github.tiagoadmstz.blocks.zero;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro 0190: Identificação das Unidades de Medida.
 */
@Data
public class IdentificacaoUnidadesMedida implements EfdBlockPart {

    private final String reg = "0190";
    private String unid;
    private String descr;
}
