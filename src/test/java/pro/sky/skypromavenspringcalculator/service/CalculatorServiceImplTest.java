package pro.sky.skypromavenspringcalculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    private final CalculatorServiceImpl calcservice = new CalculatorServiceImpl();

    @Test
    void calculator() {
        assertEquals("Добро пожаловать в калькулятор", calcservice.calculator());
    }

    @Test
    void plus() {
        assertEquals(10, calcservice.plus(5, 5));
        assertEquals(5, calcservice.plus(0, 5));
        assertEquals(4, calcservice.plus(-1, 5));
        assertEquals(4, calcservice.plus(5, -1));
        assertEquals(0, calcservice.plus(-5, 5));
        assertEquals(0, calcservice.plus(5, -5));
        assertEquals(0, calcservice.plus(0, 0));

    }

    @Test
    void minus() {
        assertEquals(0, calcservice.minus(5, 5));
        assertEquals(-5, calcservice.minus(0, 5));
        assertEquals(-6, calcservice.minus(-1, 5));
        assertEquals(6, calcservice.minus(5, -1));
        assertEquals(-10, calcservice.minus(-5, 5));
        assertEquals(10, calcservice.minus(5, -5));
        assertEquals(0, calcservice.minus(0, 0));
    }

    @Test
    void multiply() {
        assertEquals(25, calcservice.multiply(5, 5));
        assertEquals(0, calcservice.multiply(0, 5));
        assertEquals(-5, calcservice.multiply(-1, 5));
        assertEquals(-5, calcservice.multiply(5, -1));
        assertEquals(-25, calcservice.multiply(-5, 5));
        assertEquals(-25, calcservice.multiply(5, -5));
        assertEquals(0, calcservice.multiply(0, 0));
    }

    @Test
    void divide() {
        assertEquals(1, calcservice.divide(5, 5));
        assertEquals(0, calcservice.divide(0, 5));
        assertEquals(0, calcservice.divide(-1, 5));
        assertEquals(-5, calcservice.divide(5, -1));
        assertEquals(-1, calcservice.divide(-5, 5));
        assertEquals(-1, calcservice.divide(5, -5));
        assertThrows(IllegalArgumentException.class, () -> calcservice.divide(0, 0));

    }
}