package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro M230: Informações Adicionais de Diferimento.
 */
@Data
public class InformacoesAdicionaisDiferimento implements EfdBlockPart {

    private final String register = "M230";
    private String cnpj;
    private BigDecimal vlVend;
    private BigDecimal vlNaoReceb;
    private BigDecimal vlContDif;
    private BigDecimal vlCredDif;
    private String codCred;
}
