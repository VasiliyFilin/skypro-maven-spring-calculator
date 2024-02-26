package pro.sky.skypromavenspringcalculator.service;

import org.apache.coyote.BadRequestException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplParamTest {

    CalculatorServiceImpl calcservice = new CalculatorServiceImpl();
    public static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(5, 5),
                Arguments.of(0, 5),
                Arguments.of(-1, 5),
                Arguments.of(5, -1),
                Arguments.of(-5, 5),
                Arguments.of(5, -5),
                Arguments.of(0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void shouldReturnCorrectResultOfAdditionTest(int num1, int num2) throws BadRequestException {
        assertEquals(num1 + num2, calcservice.plus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("args")
    void shouldReturnCorrectResultOfSubtractionTest(int num1, int num2) throws BadRequestException {
        assertEquals(num1 - num2, calcservice.minus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("args")
    void shouldReturnCorrectResultOfMultiplicationTest(int num1, int num2) throws BadRequestException {
        assertEquals(num1 * num2, calcservice.multiply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("args")
    void shouldReturnCorrectResultOfDivisionTest(int num1, int num2) throws BadRequestException {
        if (num2 == 0) {
            assertThrows(IllegalArgumentException.class, () -> calcservice.divide(num1, num2));
            return;
        }
        assertEquals(num1 / num2, calcservice.divide(num1, num2));
    }
}