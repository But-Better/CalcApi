package de.butbetter.keksys;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CalculationValidatorTest {

    @Autowired
    private CalculationValidator calc;

    //Negative price or percent are not supported
    @Test
    void negativeException() {
        assertThrows(IllegalArgumentException.class, () -> calc.calculateVAT(-50, 19));
        assertThrows(IllegalArgumentException.class, () -> calc.calculateVAT(100, -256));

        assertThrows(IllegalArgumentException.class, () -> calc.calculateVAT(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> calc.calculateVAT(0, -1));
        assertThrows(IllegalArgumentException.class, () -> calc.calculateVAT(-1, -1));

        assertThrows(IllegalArgumentException.class, () -> calc.calculateVAT(-0.000001f, 0));
        assertThrows(IllegalArgumentException.class, () -> calc.calculateVAT(0, -0.000001f));
        assertThrows(IllegalArgumentException.class, () -> calc.calculateVAT(-0.000001f, -0.000001f));

    }

    //Integration Tests:

    @Test
    void regularValues(){
        assertEquals(110,calc.calculateVAT(100,10));
        assertEquals(20,calc.calculateVAT(10,100));
        assertEquals(30,calc.calculateVAT(10,200));

        assertEquals(10.1f,calc.calculateVAT(10,1));
        assertEquals(11,calc.calculateVAT(10,10));
        assertEquals(55,calc.calculateVAT(50,10));
        assertEquals(25,calc.calculateVAT(20,25));
    }

    //calculated Results, that are too big for float, throw an exception
    @Test
    void tooBigException() {
        assertThrows(ArithmeticException.class, () -> calc.calculateVAT(Float.MAX_VALUE, 1));
        assertThrows(ArithmeticException.class, () -> calc.calculateVAT(1000, Float.MAX_VALUE));
        assertThrows(ArithmeticException.class, () -> calc.calculateVAT(Float.MAX_VALUE, Float.MAX_VALUE));

    }

}