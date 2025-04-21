package io.github.tiagoadmstz.blocks.a;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Registro A010: Identificação do Estabelecimento.
 */
@Data
public class IdentificacaoEstabelecimentoA implements EfdBlockPart {

    private final String register = "A010";
    private Number cnpj;
    private final List<DocumentoNotaFiscalServico> documentoNotaFiscalServico;

    public IdentificacaoEstabelecimentoA() {
        documentoNotaFiscalServico = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        final Set<String> childRegisters = Set.of("A100", "A110", "A111", "A120", "A170");
        setPartListByBlock(blockLines, "A100", documentoNotaFiscalServico, DocumentoNotaFiscalServico.class, childRegisters);
    }
}
