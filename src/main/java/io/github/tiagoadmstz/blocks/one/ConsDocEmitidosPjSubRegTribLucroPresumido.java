package io.github.tiagoadmstz.blocks.one;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro 1900: Consolidação dos Documentos Emitidos no Período por Pessoa Jurídica Submetida ao Regime de Tributação com Base no Lucro Presumido–Regime de Caixa ou de Competência.
 */
@Data
public class ConsDocEmitidosPjSubRegTribLucroPresumido implements EfdBlockPart {

    private final String register = "1900";
    private String cnpj;
    private String codMod;
    private String ser;
    private String subSer;
    private String codSit;
    private BigDecimal vlTotRec;
    private Integer quantDoc;
    private String cstPis;
    private String cstCofins;
    private String cfop;
    private String infCompl;
    private String codCta;
}
