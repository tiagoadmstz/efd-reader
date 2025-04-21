package io.github.tiagoadmstz.blocks;

import io.github.tiagoadmstz.blocks.p.AberturaBlocoP;
import io.github.tiagoadmstz.blocks.p.ConsContribPrevSobreReceitaBruta;
import io.github.tiagoadmstz.blocks.p.EncerramentoBlocoP;
import io.github.tiagoadmstz.blocks.p.IdentificacaoEstabelecimento;
import io.github.tiagoadmstz.interfaces.EfdBlock;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Bloco P: Apuração da Contribuição Previdenciária sobre a Receita Bruta (Fatos Geradores a partir de Março de 2012).
 */
@Data
public class BlockP implements EfdBlock {

    private final AberturaBlocoP aberturaBlocoP;
    private final List<IdentificacaoEstabelecimento> identificacaoEstabelecimentos;
    private final List<ConsContribPrevSobreReceitaBruta> consContribPrevSobreReceitaBrutas;
    private final EncerramentoBlocoP encerramentoBlocoP;

    public BlockP() {
        this.aberturaBlocoP = new AberturaBlocoP();
        this.identificacaoEstabelecimentos = new ArrayList<>(1);
        this.consContribPrevSobreReceitaBrutas = new ArrayList<>(1);
        this.encerramentoBlocoP = new EncerramentoBlocoP();
    }

    public void setByLineNEW(final List<String> lines) {
        final List<String> blockLines = lines.stream()
                .filter(line -> line.startsWith("P", 1))
                .toList();
        aberturaBlocoP.setByLine(blockLines);
        final Set<String> childRegisters = Set.of("P010", "P100", "P110", "P199");
        setPartListByBlock(blockLines, "P010", identificacaoEstabelecimentos, IdentificacaoEstabelecimento.class, childRegisters);
        setPartListByBlock(blockLines, "P200", consContribPrevSobreReceitaBrutas, ConsContribPrevSobreReceitaBruta.class, Set.of("P210"));
        encerramentoBlocoP.setByLine(blockLines);
    }
}
