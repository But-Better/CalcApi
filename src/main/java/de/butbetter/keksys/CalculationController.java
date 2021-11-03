package de.butbetter.keksys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {

    @Autowired
    private Calculator calculator;

    @GetMapping("/VAT")
    public String calculation() {
        return "Hello WOrld";
    }
}
