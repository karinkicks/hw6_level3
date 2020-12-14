package ru.homework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ArrayUtilsTest {

    @ParameterizedTest
    @MethodSource("stringProviderForFirstTest")
    void shouldCheckCreateNewArraySuccessfully(int[] array1,int[] array2){
        Assertions.assertArrayEquals(array1, ArrayUtils.changeArray(array2));
    }

    @ParameterizedTest
    @MethodSource("stringProviderForSecondTest")
    void shouldCheckCreateNewArrayWithExceptionOK(int[] array) {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ArrayUtils.changeArray(array);
        });
    }

    @ParameterizedTest
    @MethodSource("stringProviderForThirdTest")
    void shouldCheckArrayForNumbersOneAndFourSuccessfully(int[] array){
        Assertions.assertTrue(ArrayUtils.checkArray(array));
    }

    @ParameterizedTest
    @MethodSource("stringProviderForFourthTest")
    void shouldCheckArrayForNumbersOneAndFourUnsuccessfully(int[] array){
        Assertions.assertFalse(ArrayUtils.checkArray(array));
    }

    static Stream<Arguments> stringProviderForFirstTest() {
        return Stream.of(
                arguments(new int[]{1,2},new int[]{3,2,1,4,1,2}),
                arguments(new int[]{1,2,5,78,96},new int[]{4,3,2,1,4,1,2,5,78,96})
        );
    }

    static Stream<Arguments> stringProviderForSecondTest() {
        return Stream.of(
                arguments(new int[]{}),
                arguments(new int[]{3,2,1,1,2})
        );
    }

    static Stream<Arguments> stringProviderForThirdTest() {
        return Stream.of(
                arguments(new int[]{3,2,1,4,1,2})
        );
    }

    static Stream<Arguments> stringProviderForFourthTest() {
        return Stream.of(
                arguments(new int[]{3,2,4,2}),
                arguments(new int[]{3,2,1,1,2}),
                arguments(new int[]{3,2,2})
        );
    }

}
