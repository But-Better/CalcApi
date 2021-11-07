package de.butbetter.keksys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
class VATCalculator implements Calculator {

	private static final Logger log = LoggerFactory.getLogger(VATCalculator.class);

	@Override
	public Float calculateVAT(float price, float percent) {
		float return_value = ((price / 100) * percent) + price;
		log.info(price + " + " + percent + " = " + return_value);
		return roundTo2DecimalPoints(return_value);
	}

	/**
	 * rounds the value up to a given decimal point
	 */
	private float roundTo2DecimalPoints(float value) {
		float d = (float) Math.pow(10, 2);
		return Math.round(value * d) / d;
	}
}
