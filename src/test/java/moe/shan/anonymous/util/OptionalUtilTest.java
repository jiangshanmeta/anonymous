package moe.shan.anonymous.util;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OptionalUtilTest {

    @Test
    void shouldReturnOptionalWithDefaultValueIfInputOptionalIsNull() {
        Optional<String> optionalString = OptionalUtil.ofNullable(null, "");
        assertEquals("", optionalString.get());
    }

    @Test
    void shouldReturnOptionalWithDefaultValueIfInputOptionalIsEmpty() {
        Optional<String> optionalString = OptionalUtil.ofNullable(Optional.empty(), "");

        assertEquals(optionalString, Optional.of(""));
    }

    @Test
    void shouldReturnOriginalOptionalIfInputOptionalIsNotEmpty() {
        var inputOptional = Optional.of("domain data");

        assertEquals(inputOptional, OptionalUtil.ofNullable(inputOptional, ""));
        assertEquals(inputOptional, OptionalUtil.ofNullable(inputOptional, (Supplier<String>) () -> "TEST"));
    }

    @Test
    void shouldThrowErrorIfInputOptionalIsNullAndDefaultValueIsNull() {

        assertThrows(NullPointerException.class, () -> {
            OptionalUtil.ofNullable(null, (String) null);
        });

    }

    @Test
    void shouldThrowErrorIfInputOptionalIsEmptyAndDefaultValueIsNull() {

        assertThrows(NullPointerException.class, () -> {
            Optional<String> input = Optional.empty();

            OptionalUtil.ofNullable(input, (String) null);
        });
    }

    @Test
    void shouldReturnOptionalBasedOnSupplierIfInputOptionalIsNull() {
        var optionalStrings = OptionalUtil.<List<String>>ofNullable(null, () -> List.of("A", "B"));

        assertEquals(List.of("A", "B"), optionalStrings.get());
    }

    @Test
    void shouldReturnOptionalBasedOnSupplierIfInputOptionalIsEmpty() {
        var optionalStrings = OptionalUtil.<List<String>>ofNullable(Optional.empty(), () -> List.of("A", "B"));

        assertEquals(List.of("A", "B"), optionalStrings.get());
    }

}