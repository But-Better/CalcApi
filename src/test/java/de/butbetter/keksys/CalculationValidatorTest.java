package de.butbetter.keksys;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CalculationValidatorTest {

    private Calculator calc;

    @BeforeEach
    void setup() {
        calc = new CalculationValidator();
    }

    @Test
    void calculateNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> calc.calculateVAT(-50, 19));
        assertThrows(IllegalArgumentException.class, () -> calc.calculateVAT(100, -256));
    }

    // integration test, implement after stage
    @Test
    void calculateMax() {
        assertThrows(ArithmeticException.class, () -> calc.calculateVAT(Float.MAX_VALUE, 1));
    }

}