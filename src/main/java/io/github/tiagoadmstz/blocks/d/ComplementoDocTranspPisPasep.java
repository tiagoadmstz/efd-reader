package io.github.tiagoadmstz.blocks.d;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro D101: Complemento do Documento de Transporte (Códigos 07, 08, 8B, 09, 10, 11, 26, 27, 57, 63 e 67) – PIS/Pasep.
 */
@Data
public class ComplementoDocTranspPisPasep implements EfdBlockPart {

    private final String register = "D101";
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
    private Number cstPis;
    private String natBcCred;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal vlPis;
    private String codCta;
}
