package io.github.tiagoadmstz.blocks.p;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Registro P010: Identificação do Estabelecimento.
 */
@Data
public class IdentificacaoEstabelecimento implements EfdBlockPart {

    private final String register = "P010";
    private String cnpj;
    private final List<ContribuicaoPrevidenciariaReceitaBruta> contribuicaoPrevidenciariaReceitaBrutas;

    public IdentificacaoEstabelecimento() {
        contribuicaoPrevidenciariaReceitaBrutas = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        final Set<String> childRegisters = Set.of("P100", "P110", "P199");
        setPartListByBlock(blockLines, "P100", contribuicaoPrevidenciariaReceitaBrutas, ContribuicaoPrevidenciariaReceitaBruta.class, childRegisters);
    }
}
