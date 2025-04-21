package io.github.tiagoadmstz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tiagoadmstz.blocks.BlockA;
import io.github.tiagoadmstz.blocks.BlockC;
import io.github.tiagoadmstz.blocks.BlockD;
import io.github.tiagoadmstz.blocks.BlockF;
import io.github.tiagoadmstz.blocks.BlockI;
import io.github.tiagoadmstz.blocks.BlockM;
import io.github.tiagoadmstz.blocks.BlockNine;
import io.github.tiagoadmstz.blocks.BlockOne;
import io.github.tiagoadmstz.blocks.BlockP;
import io.github.tiagoadmstz.blocks.BlockZero;
import io.github.tiagoadmstz.blocks.zero.AberturaArquivoDigital;
import io.github.tiagoadmstz.interfaces.EfdBlock;
import jakarta.inject.Inject;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EfdFile {

    @JsonProperty("abertura-arquivo")
    private final AberturaArquivoDigital aberturaArquivoDigital = new AberturaArquivoDigital();
    @JsonProperty("bloco-zero")
    private final BlockZero blockZero;
    @JsonProperty("bloco-a")
    private final BlockA blockA;
    @JsonProperty("bloco-c")
    private final BlockC blockC;
    @JsonProperty("bloco-d")
    private final BlockD blockD;
    @JsonProperty("bloco-f")
    private final BlockF blockF;
    @JsonProperty("bloco-i")
    private final BlockI blockI;
    @JsonProperty("bloco-m")
    private final BlockM blockM;
    @JsonProperty("bloco-p")
    private final BlockP blockP;
    @JsonProperty("bloco-1")
    private final BlockOne blockOne;
    @JsonProperty("bloco-9")
    private final BlockNine blockNine;

    private List<EfdBlock> blocks;

    @Inject
    public EfdFile(
            BlockZero blockZero,
            BlockA blockA, BlockC blockC, BlockD blockD, BlockF blockF,
            BlockI blockI, BlockM blockM, BlockP blockP,
            BlockOne blockOne,
            BlockNine blockNine
    ) {
        this.blockZero = blockZero;
        this.blockA = blockA;
        this.blockC = blockC;
        this.blockD = blockD;
        this.blockF = blockF;
        this.blockI = blockI;
        this.blockM = blockM;
        this.blockP = blockP;
        this.blockOne = blockOne;
        this.blockNine = blockNine;
    }

    public void setEfdFile(final List<String> lines) {
        aberturaArquivoDigital.setByLine(lines.getFirst());
        blockZero.setByLineNEW(lines);
        blockA.setByLineNEW(lines);
        blockC.setByLineNEW(lines);
        blockD.setByLineNEW(lines);
        blockF.setByLineNEW(lines);
        blockI.setByLineNEW(lines);
        blockM.setByLineNEW(lines);
        blockP.setByLineNEW(lines);
        blockNine.setByLineNEW(lines);
        blockOne.setByLineNEW(lines);
    }

    public String toString() {
        final String efdFile = getBlocks().stream()
                .map(EfdBlock::toTxtFormat)
                .collect(Collectors.joining("\n"));
        return String.join("\n", aberturaArquivoDigital.toTxtFormat(), efdFile);
    }

    private List<EfdBlock> getBlocks() {
        if (Objects.isNull(blocks)) {
            blocks = Arrays.asList(
                    blockZero,
                    blockA, blockC, blockD, blockF, blockI, blockM, blockP,
                    blockOne, blockNine
            );
        }
        return blocks;
    }
}
