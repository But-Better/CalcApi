package de.butbetter.keksys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
class VATCalculator implements Calculator {

	private static final Logger log = LoggerFactory.getLogger(VATCalculator.class);

	private static final DecimalFormat df = new DecimalFormat("0.00");

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
		return Float.parseFloat(df.format(value));
	}
}
