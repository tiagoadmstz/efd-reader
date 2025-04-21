package io.github.tiagoadmstz.blocks.f;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro F120: Bens Incorporados ao Ativo Imobilizado – Operações Geradoras de Créditos com Base nos Encargos de Depreciação e Amortização.
 */
@Data
public class BensIncorporadosAtivoImobilizado implements EfdBlockPart {

    private final String register = "F120";
    /**
     * Código da Base de Cálculo do Crédito sobre Bens Incorporados ao Ativo Imobilizado, conforme a Tabela indicada no item 4.3.7:
     * 09 = Crédito com Base nos Encargos de Depreciação;
     * 11 = Crédito com Base nos Encargos de Amortização
     */
    private String natBcCred;
    /**
     * Identificação dos Bens/Grupo de Bens Incorporados ao Ativo Imobilizado:
     * 01 = Edificações e Benfeitorias em Imóveis Próprios;
     * 02 = Edificações e Benfeitorias em Imóveis de Terceiros;
     * 03 = Instalações;
     * 04 = Máquinas;
     * 05 = Equipamentos;
     * 06 = Veículos;
     * 99 = Outros.
     */
    private Number identBemImob;
    /**
     * Indicador da origem do bem incorporado ao ativo imobilizado, gerador de crédito:
     * 0 – Aquisição no Mercado Interno
     * 1 – Aquisição no Mercado Externo (Importação)
     */
    private Number indOrigCred;
    /**
     * Indicador da Utilização dos Bens Incorporados ao Ativo Imobilizado:
     * 1 – Produção de Bens Destinados a Venda;
     * 2 – Prestação de Serviços;
     * 3 – Locação a Terceiros;
     * 9 – Outros.
     */
    private Number indUtilBemImob;
    private BigDecimal vlOperDep;
    private BigDecimal parcOperNaoBcCred;
    private Number cstPis;
    private BigDecimal vlBcPis;
    private BigDecimal aliqPis;
    private BigDecimal vlPis;
    private Number cstCofins;
    private BigDecimal vlBcCofins;
    private BigDecimal aliqCofins;
    private BigDecimal vlCofins;
    private String codCta;
    private String codCcus;
    private String descBemImob;
    private final List<ProcessoReferenciadoAtivoImob> processoReferenciadoAtivoImobs;

    public BensIncorporadosAtivoImobilizado() {
        this.processoReferenciadoAtivoImobs = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "F129", processoReferenciadoAtivoImobs, ProcessoReferenciadoAtivoImob.class);
    }
}
