package io.github.tiagoadmstz.annotations;

public @interface EfdBlockPart {

    String register();
    int order();
    boolean required() default false;
    int size() default 4;

}
