package de.butbetter.keksys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationValidator implements Calculator {

    private static final Logger log = LoggerFactory.getLogger(CalculationValidator.class);

    @Autowired
    private Calculator calculator;

    @Override
    public Float calculateVAT(float price, float percent) throws IllegalArgumentException, ArithmeticException {
        belowThanZero(price, percent);
        Float priceWithVAT = calculator.calculateVAT(price, percent);
        priceWithVATInfinityCheck(priceWithVAT);
        return priceWithVAT;
    }

    /**
     * takes price and percent input for VAT Calculation and checks if they or one of them are/is below 0
     *
     * @param price   potentially below 0
     * @param percent potentially below 0
     * @throws IllegalArgumentException if both or one of the inputs is below 0
     */
    private void belowThanZero(Float price, Float percent) {
        if (price < 0 || percent < 0) {
            String message = "either the given input: " + price + " or the percentage: " + percent + " was negative, " +
                    "which is not supported by this method";
            log.error(message);
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Checks if the calculated priceWithVAT is too big for his given datatype
     *
     * @param priceWithVAT potential infinity float value
     * @throws ArithmeticException thrown, if input value is infinite
     */
    private void priceWithVATInfinityCheck(Float priceWithVAT) throws ArithmeticException {
        if (Float.isInfinite(priceWithVAT)) {
            String message = "the calculated value is larger than the given type, therefore it will be infinite";
            log.error(message);
            throw new ArithmeticException(message);
        }
    }
}
