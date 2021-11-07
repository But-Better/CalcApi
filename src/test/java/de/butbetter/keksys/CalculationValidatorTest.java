package de.butbetter.keksys;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculationValidatorTest {

    Calculator calc;

    @BeforeEach
    void setup() {
        calc = new CalculationValidator();
    }

    @Test
    void calculateNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> calc.calculateVAT(-50, 19));
        assertThrows(IllegalArgumentException.class, () -> calc.calculateVAT(100, -256));
    }

    @Test
    void calculateMax() {
        assertTrue(false);
        // assertThrows(ArithmeticException.class, () -> calc.calculateVAT(Float.MAX_VALUE, 1));

    }

}