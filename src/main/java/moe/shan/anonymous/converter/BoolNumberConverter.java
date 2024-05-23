package moe.shan.anonymous.converter;

import org.springframework.data.convert.PropertyValueConverter;
import org.springframework.data.convert.ValueConversionContext;

public class BoolNumberConverter implements PropertyValueConverter<Boolean,Number, ValueConversionContext<?>> {

    @Override
    public Boolean read(Number value, ValueConversionContext context) {
        return value.intValue() == 1;
    }

    @Override
    public Number write(Boolean value, ValueConversionContext context) {
        return value.booleanValue()? 1:0;
    }
}
