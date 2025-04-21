package io.github.tiagoadmstz.modules;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import io.github.tiagoadmstz.EfdFile;
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
import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;

public class EfdModule extends AbstractModule {

    private static final String BASE_PACKAGE = "io.github.tiagoadmstz.blocks";

    @Override
    protected void configure() {
        bind(new TypeLiteral<List<?>>() {
        }).toInstance(new ArrayList<>());
        bindBlockZero();
        bind(BlockA.class);
        bind(BlockC.class);
        bind(BlockD.class);
        bind(BlockF.class);
        bind(BlockI.class);
        bind(BlockM.class);
        bind(BlockP.class);
        bind(BlockOne.class);
        bind(BlockNine.class);
        bind(EfdFile.class);
    }

    private void bindBlockZero() {
        bind(BlockZero.class);
        final Reflections reflections = new Reflections(BASE_PACKAGE + ".zero");
        reflections.getSubTypesOf(EfdBlockPart.class).forEach(this::bind);
    }
}
