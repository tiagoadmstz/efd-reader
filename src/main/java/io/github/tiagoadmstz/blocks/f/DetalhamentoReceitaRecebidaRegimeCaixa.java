package io.github.tiagoadmstz.blocks.f;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Registro F525: Composição da Receita Escriturada no Período – Detalhamento da Receita Recebida pelo Regime de Caixa.
 */
@Data
public class DetalhamentoReceitaRecebidaRegimeCaixa implements EfdBlockPart {

    private final String register = "F525";
    private BigDecimal vlRec;
    private String indRec;
    private String cnpjCpf;
    private String numDoc;
    private String codItem;
    private BigDecimal vlRecDet;
    private Number cstPis;
    private Number cstCofins;
    private String infoCompl;
    private String codCta;
}
