package io.github.tiagoadmstz.blocks;

import io.github.tiagoadmstz.blocks.d.AberturaBlocoD;
import io.github.tiagoadmstz.blocks.d.EncerramentoBlocoD;
import io.github.tiagoadmstz.blocks.d.IdentificacaoEstabelecimento;
import io.github.tiagoadmstz.interfaces.EfdBlock;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Bloco D:Documentos Fiscais – II - Serviços (ICMS).
 */
@Data
public class BlockD implements EfdBlock {

    private final AberturaBlocoD aberturaBlocoD;
    private final List<IdentificacaoEstabelecimento> identificacaoEstabelecimentos;
    private final EncerramentoBlocoD encerramentoBlocoD;

    public BlockD() {
        this.aberturaBlocoD = new AberturaBlocoD();
        this.identificacaoEstabelecimentos = new ArrayList<>(1);
        this.encerramentoBlocoD = new EncerramentoBlocoD();
    }

    public void setByLineNEW(final List<String> lines) {
        final List<String> blockLines = lines.stream()
                .filter(line -> line.startsWith("D", 1))
                .toList();
        aberturaBlocoD.setByLine(blockLines);
        final Set<String> childRegisters = Set.of(
                "D010", "D100", "D101", "D105", "D111", "D200", "D201", "D205", "D209", "D300", "D309",
                "D350", "D359", "D500", "D501", "D505", "D509", "D600", "D601", "D605", "D609"
        );
        setPartListByBlock(blockLines, "D010", identificacaoEstabelecimentos, IdentificacaoEstabelecimento.class, childRegisters);
        encerramentoBlocoD.setByLine(blockLines);
    }
}
