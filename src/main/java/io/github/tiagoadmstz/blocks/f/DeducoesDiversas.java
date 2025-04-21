package io.github.tiagoadmstz.blocks.f;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro F700: Deduções Diversas.
 */
@Data
public class DeducoesDiversas implements EfdBlockPart {

    private final String register = "F700";
    /**
     * Indicador de Origem de Deduções Diversas:
     * 01 – Créditos Presumidos - Medicamentos;
     * 02 – Créditos Admitidos no Regime Cumulativo – Bebidas Frias;
     * 03 – Contribuição Paga pelo Substituto Tributário - ZFM;
     * 04 – Substituição Tributária – Não Ocorrência do Fato Gerador Presumido;
     * 99 - Outras Deduções.
     */
    private String indOriDed;
    /**
     * Indicador da Natureza da Dedução:
     * 0 – Dedução de Natureza Não Cumulativa;
     * 1 – Dedução de Natureza Cumulativa.
     */
    private String indNatDed;
    private BigDecimal vlDedPis;
    private BigDecimal vlDedCofins;
    private BigDecimal vlBcOper;
    private String cnpj;
    private String infComp;
}
