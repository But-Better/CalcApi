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
        assertEquals(this.calcuationController.calculation(-1, 100).getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    void sendParameter0and0(){
        assertEquals(this.calcuationController.calculation(0, 0).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void sendParameterMinus1andMinus1(){
        assertEquals(this.calcuationController.calculation(-1, -1).getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    void sendParameter0andMinus1(){
        assertEquals(this.calcuationController.calculation(0, -1).getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    void sendParameterFloatMaxAndMinus1(){
        assertEquals(this.calcuationController.calculation(Float.MAX_VALUE, -1).getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    void sendParameterFloatMinAndMinus1(){
        assertEquals(this.calcuationController.calculation(Float.MIN_VALUE, -1).getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    void sendParameterFloatMinAndMinusFloatMax(){
        assertEquals(this.calcuationController.calculation(Float.MIN_VALUE, Float.MAX_VALUE).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void sendParameterTooBig(){
        assertEquals(this.calcuationController.calculation(Float.MAX_VALUE, Float.MAX_VALUE).getStatusCode(), HttpStatus.BAD_REQUEST);

    }

}
