package de.butbetter.keksys;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcuationController {

    @GetMapping("/")
    public Object calculation() {
        return new Object();
    }
}
