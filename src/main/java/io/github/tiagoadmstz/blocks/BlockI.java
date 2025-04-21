package io.github.tiagoadmstz.blocks;

import io.github.tiagoadmstz.blocks.i.AberturaBlocoI;
import io.github.tiagoadmstz.blocks.i.EncerramentoBlocoI;
import io.github.tiagoadmstz.blocks.i.IdentificacaoPessoaJuridica;
import io.github.tiagoadmstz.interfaces.EfdBlock;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Bloco I: Operações das Instituições Financeiras e Assemelhadas, Seguradoras, Entidades de Previdência Privada e Operadoras de Planos de Assistência à Saúde.
 */
@Data
public class BlockI implements EfdBlock {

    private final AberturaBlocoI aberturaBlocoI;
    private final List<IdentificacaoPessoaJuridica> identificacaoPessoaJuridicas;
    private final EncerramentoBlocoI encerramentoBlocoI;

    public BlockI() {
        this.aberturaBlocoI = new AberturaBlocoI();
        this.identificacaoPessoaJuridicas = new ArrayList<>(1);
        this.encerramentoBlocoI = new EncerramentoBlocoI();
    }

    public void setByLineNEW(final List<String> lines) {
        final List<String> blockLines = lines.stream()
                .filter(line -> line.startsWith("I", 1))
                .toList();
        aberturaBlocoI.setByLine(blockLines);
        final Set<String> childRegisters = Set.of("I010", "I100", "I199", "I200", "I299", "I300", "I399");
        setPartListByBlock(blockLines, "I010", identificacaoPessoaJuridicas, IdentificacaoPessoaJuridica.class, childRegisters);
        encerramentoBlocoI.setByLine(blockLines);
    }
}
