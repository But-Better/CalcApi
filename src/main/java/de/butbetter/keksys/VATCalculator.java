package de.butbetter.keksys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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
		return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).floatValue();
	}
}
