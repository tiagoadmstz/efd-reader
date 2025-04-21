package io.github.tiagoadmstz.blocks.zero;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

// Registro 0200: Tabela de Cadastro do Participante
@Data
public class IdentificacaoItem implements EfdBlockPart {

    private final String register = "0200";
    private String codPart;
    private String nome;
    private String cpfCnpj;
    private String ie;
    private String endereco;
    private String cidade;
    private String uf;
    private List<AlteracaoItem> alteracaoItems;
    private CodigoProdutoANP codigoProdutoANP;
    private CodigoGrupoMarcaComercial codigoGrupoMarcaComercial;

    public IdentificacaoItem() {
        this.alteracaoItems = new ArrayList<>(1);
        this.codigoProdutoANP = new CodigoProdutoANP();
        this.codigoGrupoMarcaComercial = new CodigoGrupoMarcaComercial();
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "0205", alteracaoItems, AlteracaoItem.class);
        codigoProdutoANP.setByLine(blockLines);
        codigoGrupoMarcaComercial.setByLine(blockLines);
    }
}
