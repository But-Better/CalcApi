package de.butbetter.keksys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
class VATCalculator implements Calculator {

	private static final Logger log = LoggerFactory.getLogger(VATCalculator.class);

	private static final int ONEHUNDRED = 100;

	@Override
	public Float calculateVAT(float price, float percent) {
		float return_value = ((price / ONEHUNDRED) * percent) + price;
		log.info("price: " + price + " + percent = " + return_value);
		return return_value;
	}
}
