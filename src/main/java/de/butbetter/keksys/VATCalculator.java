package de.butbetter.keksys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VATCalculator implements Calculator {

	private static final Logger log = LoggerFactory.getLogger(VATCalculator.class);

	@Override
	public Float calculateVAT(float input, float percent) {
		try {
			return ((input / 100) * percent) + input;
		} catch (Exception e) {
			return (float) 0;
		}
	}
}