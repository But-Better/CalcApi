package de.butbetter.keksys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VATCalculator implements Calculator {

	private static final Logger log = LoggerFactory.getLogger(VATCalculator.class);

	@Override
	public Float calculateVAT(float price, float percent) throws ArithmeticException, IllegalArgumentException {
		if (price < 0 || percent < 0) {
			String message = "either the given input: " + price + " or the percentage: " + percent + " was negative, " +
					"which is not supported by this method";
			log.error(message);
			throw new IllegalArgumentException(message);
		}

		float priceWithVAT = ((price / 100) * percent) + price;
		return getInfinitySaveFloat(priceWithVAT);
	}

	/**
	 * Float checker for infinity
	 * @param input potential infinity float value
	 * @return float
	 * @throws ArithmeticException thrown, if input value is infinite ()
	 */
	private Float getInfinitySaveFloat(Float input) throws ArithmeticException {
		if (Float.isInfinite(input)) {
			String message = "the calculated value is larger than the given type, therefore it will be infinite";
			log.error(message);
			throw new ArithmeticException(message);
		}
		return input;
	}
}
