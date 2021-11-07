package de.butbetter.keksys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("calc/v1/")
public class CalculationController {

    private static final Logger logger = LoggerFactory.getLogger(CalculationController.class);

    @Autowired
    private CalculationValidator calculationValidator;

    /**
     * GET-Request for VAT Calculation
     *
     * @param price   = 0 - Float.Max
     * @param percent = 0 - Float.Max
     * @return ResponseEntity if all correct you will get HttpStatus.OK and VAT result as json
     */
    @GetMapping("/VAT")
    public ResponseEntity<Object> calculation(
            @RequestParam(value = "price") float price,
            @RequestParam(value = "percent") float percent
    ) {

        try {
            Float result = calculationValidator.calculateVAT(price, percent);
            logger.info("Price: " + price + " Percent: " + percent);
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (IllegalArgumentException | ArithmeticException e) {
            logger.error("Message. " + e.getMessage() + " , " + Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
