package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

/**
 * Registro 1011: Detalhamento das Contribuições com Exigibilidade Suspensa.
 */
@Data
public class DetalhamentoContribuicoesExibSuspensa implements EfdBlockPart {

    private final String register = "1011";
    private String regRef;
    private String chaveDoc;
    private String codPart;
    private String codItem;
    private String dtOper;
    private Double vlOper;
    private String cstPis;
    private Double vlBcPis;
    private String aliqPis;
    private Double vlPis;
    private String cstCofins;
    private Double vlBcCofins;
    private String aliqCofins;
    private Double vlCofins;
    private String cstPisSusp;
    private Double vlBcPisSusp;
    private String aliqPisSusp;
    private Double vlPisSusp;
    private String cstCofinsSusp;
    private Double vlBcCofinsSusp;
    private String aliqCofinsSusp;
    private Double vlCofinsSusp;
    private String codCta;
    private String codCcus;
    private String descDocOper;
}
