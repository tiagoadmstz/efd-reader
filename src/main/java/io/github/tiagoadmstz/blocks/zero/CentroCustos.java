package io.github.tiagoadmstz.blocks.zero;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.time.LocalDate;

/**
 * Registro 0600: Centro de Custos.
 */
@Data
public class CentroCustos implements EfdBlockPart {

    private final String register = "0600";
    private LocalDate dtAlt;
    private String codCcus;
    private String ccus;
}
