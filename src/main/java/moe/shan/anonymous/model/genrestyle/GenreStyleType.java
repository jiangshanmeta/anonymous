package moe.shan.anonymous.model.genrestyle;

import org.springframework.data.convert.PropertyValueConverter;
import org.springframework.data.convert.ValueConversionContext;

import java.util.Arrays;

public enum GenreStyleType {
    UNASSIGNED(0),
    TOP_GENRE(1),
    GENRE(2),
    STYLE(3),
    SUB_STYLE(4),
    SUB_SUB_STYLE(5);

    private final Number value;

    GenreStyleType(Number value) {
        this.value = value;
    }

    public static class GenreStyleTypeConverter implements PropertyValueConverter<GenreStyleType, Number, ValueConversionContext<?>> {

        @Override
        public GenreStyleType read(Number value, ValueConversionContext<?> context) {

            return Arrays.stream(GenreStyleType.values()).filter(item -> item.value.intValue() == value.intValue()).findFirst().orElseGet(() -> GenreStyleType.UNASSIGNED);
        }

        @Override
        public Number write(GenreStyleType value, ValueConversionContext<?> context) {
            return value.value;
        }
    }
}
