package io.github.tiagoadmstz.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.IntStream;

import static org.apache.commons.lang3.StringUtils.defaultIfBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public interface EfdBlockPart {

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

    default void setByLine(List<String> blockLines) {
        try {
            final Field register = getClass().getDeclaredField("register");
            register.setAccessible(true);
            final List<String> valuesLine = getValuesLine(blockLines, register.get(this).toString());
            if (!valuesLine.isEmpty()) setByLine(valuesLine.getFirst());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    default void setByLine(final String valuesLine) {
        final String[] values = splitLine(valuesLine);
        try {
            final Field[] declaredFields = getClass().getDeclaredFields();
            for (int currentField = 2; currentField < values.length; currentField++) {
                int classField = currentField - 1;
                final Field field = classField < declaredFields.length ? declaredFields[currentField - 1] : null;
                if (Objects.nonNull(field)) {
                    field.setAccessible(true);
                    if (!"register".equals(field.getName())) {
                        Object value = null;
                        if (field.getType().equals(String.class)) {
                            value = parseString(values[currentField]);
                        } else if (field.getType().equals(Number.class)) {
                            value = parseNumber(values[currentField]);
                        } else if (field.getType().equals(BigDecimal.class)) {
                            value = parseBigDecimal(values[currentField]);
                        } else if (field.getType().equals(LocalDate.class)) {
                            value = parseLocalDate(values[currentField]);
                        }

                        if (Objects.nonNull(value)) field.set(this, value);
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

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

    default List<String> getValuesLine(final List<String> blockLines, final String register) {
        return blockLines.stream().filter(bl -> bl.startsWith(register, 1)).toList();
    }

    default String[] splitLine(final String line) {
        return line.split("\\|");
    }

    default String parseString(final String entryValue) {
        return defaultIfBlank(entryValue, null);
    }

    default Number parseNumber(final String entryValue) {
        if (isNotBlank(entryValue)) {
            return Long.parseLong(entryValue);
        }
        return null;
    }

    default LocalDate parseLocalDate(final String entryValue) {
        if (isNotBlank(entryValue)) {
            final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
            return LocalDate.parse(entryValue, dateTimeFormatter);
        }
        return null;
    }

    default Number parseBigDecimal(final String entryValue) {
        final NumberFormat numberFormat = NumberFormat.getInstance(Locale.of("pt", "BR"));
        if (isNotBlank(entryValue)) {
            try {
                return new BigDecimal(numberFormat.parse(entryValue).toString());
            } catch (ParseException exception) {
                return null;
            }
        }
        return null;
    }

    @JsonIgnore
    default String toTxtFormat() {
        if (isAllNull()) return "";
        try {
            final StringJoiner partsJoiner = new StringJoiner("\n");
            final StringJoiner valuesJoiner = new StringJoiner("|").add("");
            final Field[] fields = getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                final Object value = field.get(this);
                if (value instanceof LocalDate) {
                    final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
                    valuesJoiner.add(value != null ? ((LocalDate) value).format(dateTimeFormatter) : "");
                } else if (value instanceof BigDecimal) {
                    valuesJoiner.add(value != null ? String.format("%.2f", value).replace(".", ",") : "");
                } else if (value instanceof List<?>) {
                    if (!((List) value).isEmpty())
                        ((List<EfdBlockPart>) value).forEach(item -> partsJoiner.add(item.toTxtFormat()));
                } else if (value instanceof EfdBlockPart) {
                    final String txtFormat = ((EfdBlockPart) value).toTxtFormat();
                    if (isNotBlank(txtFormat)) partsJoiner.add(txtFormat);
                } else {
                    valuesJoiner.add(Objects.nonNull(value) ? value.toString() : "");
                }
            }
            if (partsJoiner.length() > 0) return String.format("%s\n%s", valuesJoiner.add(""), partsJoiner);
            return valuesJoiner.add("").toString();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @JsonIgnore
    default boolean isAllNull() {
        try {
            final Field[] fields = getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                final Object value = field.get(this);
                if ((!"register".equalsIgnoreCase(field.getName()) && !(value instanceof EfdBlockPart) && Objects.nonNull(value))
                    || (value instanceof EfdBlockPart && ((EfdBlockPart) value).isAllNonNull())
                ) {
                    return false;
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }

    @JsonIgnore
    default boolean isAllNonNull() {
        return !isAllNull();
    }
}
