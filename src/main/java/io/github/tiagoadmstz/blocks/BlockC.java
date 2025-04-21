package io.github.tiagoadmstz.blocks;

import io.github.tiagoadmstz.blocks.c.AberturaBlocoC;
import io.github.tiagoadmstz.blocks.c.EncerramentoBlocoC;
import io.github.tiagoadmstz.blocks.c.IdentificacaoEstabelecimentoC;
import io.github.tiagoadmstz.interfaces.EfdBlock;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Bloco C: Documentos Fiscais – I - Mercadorias (ICMS/IPI).
 */
@Data
public class BlockC implements EfdBlock {

    private final AberturaBlocoC aberturaBlocoC;
    private final List<IdentificacaoEstabelecimentoC> identificacaoEstabelecimentos;
    private final EncerramentoBlocoC encerramentoBlocoC;

    public BlockC() {
        aberturaBlocoC = new AberturaBlocoC();
        identificacaoEstabelecimentos = new ArrayList<>(1);
        encerramentoBlocoC = new EncerramentoBlocoC();
    }

    public void setByLineNEW(final List<String> lines) {
        final List<String> blockLines = lines.stream()
                .filter(line -> line.startsWith("C", 1))
                .toList();
        aberturaBlocoC.setByLine(blockLines);
        final Set<String> childRegisters = Set.of(
                "C010", "C100", "C111", "C120", "C170", "C175", "C180", "C181", "C185", "C188",
                "C190", "C191", "C195", "C198", "C199", "C380", "C381", "C385", "C395", "C396",
                "C400", "C405", "C481", "C485", "C489", "C490", "C491", "C495", "C499", "C500",
                "C501", "C505", "C509", "C600", "C601", "C605", "C609", "C800", "C810", "C820",
                "C830", "C860", "C870", "C880", "C890"
        );
        setPartListByBlock(blockLines, "C010", identificacaoEstabelecimentos, IdentificacaoEstabelecimentoC.class, childRegisters);
        encerramentoBlocoC.setByLine(blockLines);
    }
}
