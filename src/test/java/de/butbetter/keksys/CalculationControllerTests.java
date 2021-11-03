package de.butbetter.keksys;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CalculationControllerTests {

    @Autowired
    private CalculationController calcuationController;

    @Test
    void contextLoads() {
        assertThat(calcuationController).isNotNull();
    }

}
