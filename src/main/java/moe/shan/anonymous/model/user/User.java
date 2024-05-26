package moe.shan.anonymous.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import moe.shan.anonymous.util.OptionalUtil;
import org.springframework.data.annotation.Id;
import org.springframework.data.convert.PropertyValueConverter;
import org.springframework.data.convert.ValueConversionContext;
import org.springframework.data.convert.ValueConverter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;
import java.util.Optional;

@Document(collection = "users")
public record User(
        @Id String id,
        String name,
        String phone,
        @Field("reg_ts") int regTS,
        @JsonIgnore String password,
        @ValueConverter(UserTypeConverter.class) UserType type,
        @Field("counter_contribute") Optional<Integer> counterContribute,
        @Field("counter_view") Optional<Integer> counterView,
        @Field("hot_index") Optional<Integer> hotIndex
) {
    public User {
        counterContribute = OptionalUtil.ofNullable(counterContribute, 0);
        counterView = OptionalUtil.ofNullable(counterView, 0);
        hotIndex = OptionalUtil.ofNullable(hotIndex, 0);

    }

    public enum UserType {
        User(0),
        EDITOR(1),
        COLUMN_EDITOR(2),
        EDITOR_CHIEF(3),
        Neuromancer(4);
        private final Number value;

        UserType(Number value) {
            this.value = value;
        }

    }

    public static class UserTypeConverter implements PropertyValueConverter<UserType, Number, ValueConversionContext<?>> {

        @Override
        public UserType read(Number value, ValueConversionContext<?> context) {
            return Arrays.stream(UserType.values()).filter(item -> item.value.intValue() == value.intValue()).findFirst().orElseGet(() -> UserType.User);
        }

        @Override
        public Number write(UserType value, ValueConversionContext<?> context) {
            return value.value;
        }
    }
}
