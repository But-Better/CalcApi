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
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("calc/v1/")
public class CalculationController {

    private static final Logger logger = LoggerFactory.getLogger(CalculationController.class);
    private static final String JSON_VAT_NAME = "VAT-Result";

    @Autowired
    private CalculationValidator calculationValidator;

    /**
     * GET-Request for VAT Calculation
     *
     * @param price   = price like 40, 500 or 100000000
     * @param percent = VAT percent value like 40%, 10% and 1%
     * @return ResponseEntity if all correct you will get HttpStatus.OK and VAT result as json
     */
    @GetMapping("/VAT")
    public ResponseEntity<Object> calculation(
            @RequestParam(value = "price") float price,
            @RequestParam(value = "percent") float percent
    ) {
        try {
            Float resultWithVAT = calculationValidator.calculateVAT(price, percent);
            logger.info(String.format("(%.2f / 100) * %.2f) + %.2f = %.2f", price, percent, price, resultWithVAT));
            Map<String, Float> jsonObject = new HashMap<>();
            jsonObject.put(JSON_VAT_NAME, resultWithVAT);

            return new ResponseEntity<>(jsonObject, HttpStatus.OK);

        } catch (IllegalArgumentException | ArithmeticException e) {
            logger.error("Message. " + e.getMessage() + " , " + Arrays.toString(e.getStackTrace()));
            Map<String, String> errorObject = new HashMap<>();
            errorObject.put("Error", e.getMessage());
            return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
        }
    }
}
