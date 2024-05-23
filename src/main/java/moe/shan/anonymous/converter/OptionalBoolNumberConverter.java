package moe.shan.anonymous.converter;

import org.springframework.data.convert.PropertyValueConverter;
import org.springframework.data.convert.ValueConversionContext;

import java.util.Optional;

public class OptionalBoolNumberConverter implements PropertyValueConverter<Optional<Boolean>,Number, ValueConversionContext<?>> {

    @Override
    public Optional<Boolean> read(Number value, ValueConversionContext<?> context) {
        return value.intValue() == 0? Optional.of(false):Optional.of(true);
    }

    @Override
    public Number write(Optional<Boolean> value, ValueConversionContext<?> context) {
        return value.get().booleanValue()?1:0;
    }
}
