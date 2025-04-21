package io.github.tiagoadmstz.blocks.d;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro D105: .
 */
@Data
public class ComplementoDocTranspCofins implements EfdBlockPart {

    private final String register = "D105";
    /**
     * Indicador da Natureza do Frete Contratado, referente a:
     * 0 – Operações de vendas, com ônus suportado pelo estabelecimento vendedor;
     * 1 – Operações de vendas, com ônus suportado pelo adquirente;
     * 2 – Operações de compras (bens para revenda, matérias-prima e outros produtos, geradores de crédito);
     * 3 – Operações de compras (bens para revenda, matérias-prima e outros produtos, não geradores de crédito);
     * 4 – Transferência de produtos acabados entre estabelecimentos da pessoa jurídica;
     * 5 – Transferência de produtos em elaboração entre estabelecimentos da pessoa jurídica;
     * 9 – Outras.
     */
    private String indNatFrt;
    private BigDecimal vlItem;
    private Number cstCofins;
    private String natBcCred;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCofins;
    private String codCta;
}
