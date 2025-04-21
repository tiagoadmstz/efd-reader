package io.github.tiagoadmstz.blocks.zero;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.time.LocalDate;

/**
 * Registro 0500: Plano de Contas Contábeis
 */
@Data
public class PlanoContasContabeis implements EfdBlockPart {

    private final String register = "0500";
    private LocalDate dtAlt;
    /**
     * Código da natureza da conta/grupo de contas:
     * 01 - Contas de ativo
     * 02 - Contas de passivo;
     * 03 - Patrimônio líquido;
     * 04 - Contas de resultado;
     * 05 - Contas de compensação;
     * 09 - Outras.
     */
    private String codNatCc;
    /**
     * Indicador do tipo de conta:
     * S - Sintética (grupo de contas);
     * A - Analítica (conta).
     */
    private String indCta;
    private Number nivel;
    private String codCta;
    private String nomeCta;
    private String codCtaRef;
    private String cnpjEst;
}
