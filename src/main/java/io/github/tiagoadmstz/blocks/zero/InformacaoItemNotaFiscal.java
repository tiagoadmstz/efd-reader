package io.github.tiagoadmstz.blocks.zero;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro 0400: Tabela de Informação do Item da Nota Fiscal
 */
@Data
public class InformacaoItemNotaFiscal implements EfdBlockPart {

    private final String reg = "0400";
    private String codNat;
    private String descrNat;
}
