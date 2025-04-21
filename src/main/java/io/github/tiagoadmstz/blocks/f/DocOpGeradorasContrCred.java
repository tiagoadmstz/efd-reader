package io.github.tiagoadmstz.blocks.f;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro F100: Demais Documentos e Operações Geradoras de Contribuição e Créditos.
 */
@Data
public class DocOpGeradorasContrCred implements EfdBlockPart {

    private final String register = "F100";
    /**
     * Indicador do Tipo da Operação:
     * 0 – Operação Representativa de Aquisição, Custos, Despesa ou Encargos, ou Receitas, Sujeita à Incidência de Crédito de PIS/Pasep ou Cofins (CST 50 a 66).
     * 1 – Operação Representativa de Receita Auferida Sujeita ao Pagamento da Contribuição para o PIS/Pasep e da Cofins (CST 01, 02, 03 ou 05).
     * 2 - Operação Representativa de Receita Auferida Não Sujeita ao Pagamento da Contribuição para o PIS/Pasep e da Cofins (CST 04, 06, 07, 08, 09, 49 ou 99).
     */
    private String indOpe;
    private String codPart;
    private String codItem;
    private LocalDate dtOper;
    private BigDecimal vlOper;
    private Number cstPis;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal vlPis;
    private Number cstCofins;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCofins;
    private String natBcCred;
    /**
     * Indicador da origem do crédito:
     * 0 – Operação no Mercado Interno
     * 1 – Operação de Importação
     */
    private Number indOrigCred;
    private String codCta;
    private String codCcus;
    private String descDocOper;
    private final List<ProcessoReferenciado> processoReferenciados;

    public DocOpGeradorasContrCred() {
        this.processoReferenciados = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "F111", processoReferenciados, ProcessoReferenciado.class);
    }
}
