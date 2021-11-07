package de.butbetter.keksys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@RequestMapping("calc/v1/")
public class CalculationController {

    private static final Logger logger = LoggerFactory.getLogger(CalculationController.class);

    //@Autowired
    //private Calculator calculator;

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
        logger.info("Price: " + price + " Percent: " + percent);

        HashMap<String, Float> results = new HashMap<>();
        results.put("priceWithVAT", price);

        return new ResponseEntity<>(
                results//calculator.calculateVAT(input, percent)
                , HttpStatus.OK
        );
    }
}
