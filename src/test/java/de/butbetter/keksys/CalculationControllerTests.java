package de.butbetter.keksys;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculationControllerTests {

    @Autowired
    private CalculationController calcuationController;

    @Test
    void contextLoads() {
        assertThat(calcuationController).isNotNull();
    }

    @Test
    void sendParameter14and100() {
        assertEquals(this.calcuationController.calculation(100, 14).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void sendParameterMinus1and100() {
        assertEquals(this.calcuationController.calculation(-1, 100).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void sendParameterDoubleMaxAndDoubleMin() {
        assertEquals(this.calcuationController.calculation(Float.MAX_VALUE + Float.MAX_VALUE, Float.MIN_VALUE + 1).getStatusCode(), HttpStatus.OK);
    }
}
