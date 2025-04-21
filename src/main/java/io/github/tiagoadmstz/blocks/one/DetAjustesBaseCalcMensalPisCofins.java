package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro 1050: Detalhamento de Ajustes de Base de Cálculo – Valores Extra Apuração.
 */
@Data
public class DetAjustesBaseCalcMensalPisCofins implements EfdBlockPart {

    private final String register = "1050";
    private String dtRef;
    private String indAjBc;
    private String cnpj;
    private BigDecimal vlAjTot;
    private BigDecimal vlAjCst01;
    private BigDecimal vlAjCst02;
    private BigDecimal vlAjCst03;
    private BigDecimal vlAjCst04;
    private BigDecimal vlAjCst05;
    private BigDecimal vlAjCst06;
    private BigDecimal vlAjCst07;
    private BigDecimal vlAjCst08;
    private BigDecimal vlAjCst09;
    private BigDecimal vlAjCst49;
    private BigDecimal vlAjCst99;
    private String indAprop;
    private String numRec;
    private String infoCompl;
}
