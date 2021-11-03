package de.butbetter.keksys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {

    private static final Logger logger = LoggerFactory.getLogger(CalculationController.class);

    //@Autowired
    //private Calculator calculator;

    /**
     * GET-Request for VAT Calculation
     * @param input = 0 - Float.Max
     * @param percent = 0 - Float.Max
     * @return ResponseEntity if all correct you will get HttpStatus.OK and VAT result as json
     */
    @GetMapping("/VAT")
    public ResponseEntity<Float> calculation(@RequestParam(value = "input") Float input, @RequestParam(value = "percent") Float percent) {
        logger.info(new StringBuilder()
                .append("Input: ")
                .append(input.toString())
                .append(" Percent: ")
                .append(percent)
                .toString()
        );

        return new ResponseEntity<>(
                input//calculator.calculateVAT(input, percent)
                , HttpStatus.OK
        );
    }
}
