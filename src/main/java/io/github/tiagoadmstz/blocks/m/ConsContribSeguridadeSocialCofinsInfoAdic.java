package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro M630: Informações Adicionais de Diferimento.
 */
@Data
public class ConsContribSeguridadeSocialCofinsInfoAdic implements EfdBlockPart {

    private final String register = "M630";
    private String cnpj;
    private BigDecimal vlVend;
    private BigDecimal vlNaoReceb;
    private BigDecimal vlContDif;
    private BigDecimal vlCredDif;
    private String codCred;
}
