package io.github.tiagoadmstz.blocks;

import io.github.tiagoadmstz.blocks.f.AberturaBlocoF;
import io.github.tiagoadmstz.blocks.f.EncerramentoBlocoF;
import io.github.tiagoadmstz.blocks.f.IdentificacaoEstabelecimento;
import io.github.tiagoadmstz.interfaces.EfdBlock;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Bloco F: Demais Documentos e Operações.
 */
@Data
public class BlockF implements EfdBlock {

    private final AberturaBlocoF aberturaBlocoF;
    private final List<IdentificacaoEstabelecimento> identificacaoEstabelecimentos;
    private final EncerramentoBlocoF encerramentoBlocoF;

    public BlockF() {
        this.aberturaBlocoF = new AberturaBlocoF();
        this.identificacaoEstabelecimentos = new ArrayList<>(1);
        this.encerramentoBlocoF = new EncerramentoBlocoF();
    }

    public void setByLineNEW(final List<String> lines) {
        final List<String> blockLines = lines.stream()
                .filter(line -> line.startsWith("F", 1))
                .toList();
        aberturaBlocoF.setByLine(blockLines);
        final Set<String> childRegisters = Set.of(
                "F010", "F100", "F111", "F120", "F129", "F130", "F139", "F150", "F200", "F205", "F210",
                "F211", "F500", "F509", "F510", "F519", "F525", "F550", "F559", "F560", "F569", "F600",
                "F700", "F800"
        );
        setPartListByBlock(blockLines, "F010", identificacaoEstabelecimentos, IdentificacaoEstabelecimento.class, childRegisters);
        encerramentoBlocoF.setByLine(blockLines);
    }
}
