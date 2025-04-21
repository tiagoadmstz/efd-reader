package io.github.tiagoadmstz.blocks;

import io.github.tiagoadmstz.blocks.nine.AberturaBlocoNine;
import io.github.tiagoadmstz.blocks.nine.EncerramentoArquivoDigital;
import io.github.tiagoadmstz.blocks.nine.EncerramentoBlocoNine;
import io.github.tiagoadmstz.blocks.nine.RegistrosArquivo;
import io.github.tiagoadmstz.interfaces.EfdBlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Bloco 9: Controle e Encerramento do Arquivo Digital.
 */
public class BlockNine implements EfdBlock {

    private final AberturaBlocoNine aberturaBlocoNine;
    private final List<RegistrosArquivo> registrosArquivos;
    private final EncerramentoBlocoNine encerramentoBlocoNine;
    private final EncerramentoArquivoDigital encerramentoArquivoDigital;

    public BlockNine() {
        this.aberturaBlocoNine = new AberturaBlocoNine();
        this.registrosArquivos = new ArrayList<>(1);
        this.encerramentoBlocoNine = new EncerramentoBlocoNine();
        this.encerramentoArquivoDigital = new EncerramentoArquivoDigital();
    }

    public void setByLineNEW(final List<String> lines) {
        final List<String> blockLines = lines.stream()
                .filter(line -> line.startsWith("9", 1))
                .toList();
        aberturaBlocoNine.setByLine(blockLines);
        setPartListByBlock(blockLines, "9900", registrosArquivos, RegistrosArquivo.class);
        encerramentoBlocoNine.setByLine(blockLines);
        encerramentoArquivoDigital.setByLine(blockLines);
    }
}
