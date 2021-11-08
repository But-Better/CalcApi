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
		float priceWithVAT = ((price / 100) * percent) + price;
		log.info(price + " + " + percent + " = " + priceWithVAT);
		return roundTo2DecimalPoints(priceWithVAT);
	}

	/**
	 * rounds the value up to a given decimal point
	 * returns infinity if value is infinity
	 */
	private float roundTo2DecimalPoints(float value) {
		if(Float.isInfinite(value)) return value;
		return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).floatValue();
	}
}
