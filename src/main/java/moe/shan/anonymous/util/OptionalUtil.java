package moe.shan.anonymous.util;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

public class OptionalUtil {
    public static <T> Optional<T> ofNullable(Optional<T> optionalT,T defaultVal){
        if(optionalT == null || optionalT.isEmpty()){
            Objects.requireNonNull(defaultVal);
            return Optional.of(defaultVal);
        }
        return optionalT;
    }

    public static <T> Optional<T> ofNullable(Optional<T> optionalT, Supplier<T> supplier){
        if(optionalT == null || optionalT.isEmpty()){
            Objects.requireNonNull(supplier);
            return Optional.of(supplier.get());
        }
        return optionalT;
    }

}
