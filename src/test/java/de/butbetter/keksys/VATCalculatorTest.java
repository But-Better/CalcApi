package de.butbetter.keksys;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VATCalculatorTest {

	private VATCalculator calc;

	@BeforeEach
	void setup() {
		calc = new VATCalculator();
	}

	@Test
	void calculateNormalNumber() {
		assertEquals(119, calc.calculateVAT(100, 19));
	}

	@Test
	void calculateNullNumber() {
		assertEquals(0, calc.calculateVAT(0, 19));
		assertEquals(100, calc.calculateVAT(100, 0));
	}
}