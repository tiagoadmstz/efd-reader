package io.github.tiagoadmstz.blocks.zero;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro 0145: Regime de Apuração da Contribuição Previdenciária Sobre a Receita Bruta;
 */
@Data
public class RegimeApuracaoCPSRB implements EfdBlockPart {

    private final String register = "0145";
    private Number codIncTrib;
    private Number vlRecTotal;
    private Number vlRecAtiv;
    private Number vlRecDemaisAtiv;
    private String infoCompl;
}
