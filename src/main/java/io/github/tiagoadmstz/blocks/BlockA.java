package io.github.tiagoadmstz.blocks;

import io.github.tiagoadmstz.blocks.a.AberturaBlocoA;
import io.github.tiagoadmstz.blocks.a.EncerramentoBloco;
import io.github.tiagoadmstz.blocks.a.IdentificacaoEstabelecimentoA;
import io.github.tiagoadmstz.interfaces.EfdBlock;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Bloco A: Documentos Fiscais - Serviços (Sujeitos ao ISS).
 */
@Data
public class BlockA implements EfdBlock {

    private final AberturaBlocoA aberturaBlocoA;
    private final List<IdentificacaoEstabelecimentoA> identificacaoEstabelecimentos;
    private final EncerramentoBloco encerramentoBloco;

    public BlockA() {
        this.aberturaBlocoA = new AberturaBlocoA();
        this.identificacaoEstabelecimentos = new ArrayList<>(1);
        this.encerramentoBloco = new EncerramentoBloco();
    }

    public void setByLineNEW(final List<String> lines) {
        final List<String> blockLines = lines.stream()
                .filter(line -> line.startsWith("A", 1))
                .toList();
        aberturaBlocoA.setByLine(blockLines);
        final Set<String> childRegisters = Set.of("A010", "A100", "A110", "A111", "A120", "A170");
        setPartListByBlock(blockLines, "A010", identificacaoEstabelecimentos, IdentificacaoEstabelecimentoA.class, childRegisters);
        encerramentoBloco.setByLine(blockLines);
    }
}
