package io.github.tiagoadmstz.interfaces;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public interface EfdBlock {

    default void setPartListByBlock(final List<String> blockLines, final String partRegister, final List target, Class<? extends EfdBlockPart> type) {
        blockLines.stream().filter(line -> line.startsWith(partRegister, 1)).forEach(line -> {
            try {
                final EfdBlockPart efdBlockPart = type.getConstructor().newInstance();
                efdBlockPart.setByLine(line);
                target.add(efdBlockPart);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    default void setPartListByBlock(final List<String> blockLines, final String register, final List target, Class<? extends EfdBlockPart> type, final Set<String> childRegisters) {
        final List<String> ceBlock = blockLines.stream()
                .filter(bl -> childRegisters.contains(bl.substring(1, 5)))
                .toList();

        for (int i = 0; i < ceBlock.size(); i++) {
            int nextIndex = i + 1;
            boolean hasNoChildren = nextIndex < ceBlock.size() && ceBlock.get(nextIndex).startsWith(register, 1);
            try {
                final EfdBlockPart efdBlockPart = type.getConstructor().newInstance();
                if (hasNoChildren) {
                    efdBlockPart.setByLine(ceBlock.get(i));
                } else {
                    int nextFatherIndex = IntStream.range(nextIndex, ceBlock.size())
                            .filter(nfi -> ceBlock.get(nfi).startsWith(register, 1))
                            .findFirst()
                            .orElse(ceBlock.size());

                    efdBlockPart.setByLine(ceBlock.subList(i, nextFatherIndex));
                    i = nextFatherIndex - 1;
                }
                target.add(efdBlockPart);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    default String toTxtFormat() {
        final StringJoiner stringJoiner = new StringJoiner("\n");
        try {
            final Field[] declaredFields = getClass().getDeclaredFields();
            for (final Field field : declaredFields) {
                field.setAccessible(true);
                if (field.getType() == List.class) {
                    ((List<EfdBlockPart>) field.get(this)).forEach(efdBlockPart -> stringJoiner.add(efdBlockPart.toTxtFormat()));
                } else {
                    final EfdBlockPart efdBlock = (EfdBlockPart) field.get(this);
                    if (efdBlock.isAllNonNull()) stringJoiner.add(efdBlock.toTxtFormat());
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return stringJoiner.toString();
    }
}
