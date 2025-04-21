package io.github.tiagoadmstz.blocks.zero;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro 208: Código de Grupos por Marca Comercial – Refri (bebidas frias)
 */
@Data
public class CodigoGrupoMarcaComercial implements EfdBlockPart {

    private final String register = "208";
    /**
     * Código indicador da Tabela de Incidência, conforme Anexo III do Decreto nº 6.707/08:
     * 01 – Tabela I
     * 02 – Tabela II
     * 03 – Tabela III
     * 04 – Tabela IV
     * 05 – Tabela V
     * 06 – Tabela VI
     * 07 – Tabela VII
     * 08– Tabela VIII
     * 09 – Tabela IX
     * 10 – Tabela X
     * 11 – Tabela XI
     * 12 – Tabela XII
     * A partir de outubro de 2012:
     * 13 – Tabela XIII
     */
    private String codTab;
    private String codGru;
    private String marcaCom;
}
