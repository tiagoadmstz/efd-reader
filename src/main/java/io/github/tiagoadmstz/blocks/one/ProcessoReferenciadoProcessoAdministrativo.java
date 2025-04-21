package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro 1020: 	Processo Referenciado – Processo Administrativo.
 */
@Data
public class ProcessoReferenciadoProcessoAdministrativo implements EfdBlockPart {

    private final String register = "1020";
    private String numProc;
    /**
     * Indicador da Natureza da Ação, decorrente de Processo Administrativo na Secretaria da Receita Federal do Brasil:
     * 01 – Processo Administrativo de Consulta;
     * 02 – Despacho Decisório;
     * 03 – Ato Declaratório Executivo;
     * 04 – Ato Declaratório Interpretativo;
     * 05 – Decisão Administrativa de DRJ ou do CARF;
     * 06 – Auto de Infração;
     * 99 – Outros.
     */
    private String indNatAcao;
    private String dtDecAdm;
}
