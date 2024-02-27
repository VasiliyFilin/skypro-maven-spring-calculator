package pro.sky.skypromavenspringcalculator.service;

import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    private final CalculatorServiceImpl calcservice = new CalculatorServiceImpl();

    @Test
    void calculator() {
        assertEquals("Добро пожаловать в калькулятор", calcservice.calculator());
    }

    @Test
    void shouldReturnCorrectResultOfAdditionTest() throws BadRequestException {
        assertEquals(10, calcservice.plus(5, 5));
        assertEquals(4, calcservice.plus(-1, 5));

    }

    @Test
    void shouldReturnCorrectResultOfSubtractionTest() throws BadRequestException {
        assertEquals(0, calcservice.minus(5, 5));
        assertEquals(-6, calcservice.minus(-1, 5));
    }

    @Test
    void shouldReturnCorrectResultOfMultiplicationTest() throws BadRequestException {
        assertEquals(25, calcservice.multiply(5, 5));
        assertEquals(-5, calcservice.multiply(-1, 5));
    }

    @Test
    void shouldReturnCorrectResultOfDivisionTest() throws BadRequestException {
        assertEquals(1, calcservice.divide(5, 5));
        assertEquals(0, calcservice.divide(-1, 5));
    }

    @Test
    void shouldThrowBadRequestExceptionWhenNumIsNullTest() {
        assertThrows(BadRequestException.class, () -> calcservice.divide(null, 5));
        assertThrows(BadRequestException.class, () -> calcservice.divide(5, null));
    }
    @Test
    void shouldThrowIllegalArgumentExceptionWhenNum2Is0Test() {
        assertThrows(IllegalArgumentException.class, () -> calcservice.divide(5, 0));
    }
}