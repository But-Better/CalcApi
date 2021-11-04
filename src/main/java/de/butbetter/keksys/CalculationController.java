package de.butbetter.keksys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CalculationController {

    private static final Logger logger = LoggerFactory.getLogger(CalculationController.class);

    //@Autowired
    //private Calculator calculator;

    /**
     * GET-Request for VAT Calculation
     *
     * @param input   = 0 - Float.Max
     * @param percent = 0 - Float.Max
     * @return ResponseEntity if all correct you will get HttpStatus.OK and VAT result as json
     */
    @GetMapping("/VAT")
    public ResponseEntity<Object> calculation(
            @RequestParam(value = "input", defaultValue = "0") float input,
            @RequestParam(value = "percent", defaultValue = "0") float percent
    ) {
        logger.info("Input: " + input + " Percent: " + percent);

        HashMap<String, Float> map = new HashMap<>();
        map.put("VAT-result", input);

        return new ResponseEntity<>(
                map//calculator.calculateVAT(input, percent)
                , HttpStatus.OK
        );
    }
}
