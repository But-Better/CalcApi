package de.butbetter.keksys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VATCalculator implements Calculator {

	private static final Logger log = LoggerFactory.getLogger(VATCalculator.class);

	@Override
	public Float calculateVAT(float input, float percent) throws IllegalArgumentException {
		input = Math.max(0, input);
		percent = Math.max(0, percent);
		float ret = ((input / 100) * percent) + input;
		if (Float.isInfinite(ret)) {
			String message = "the calculated value is larger than the given type, therefore it will be infinite";
			log.error(message);
			throw new IllegalArgumentException(message);
		}
		return ret;
	}
}
