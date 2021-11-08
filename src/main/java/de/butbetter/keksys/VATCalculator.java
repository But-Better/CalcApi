package de.butbetter.keksys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
		try {
			return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).floatValue();
		} catch (NumberFormatException e) {
			String message = "can't round " + value + ", just giving it back";
			log.error(message);
			return value;
		}
	}
}
