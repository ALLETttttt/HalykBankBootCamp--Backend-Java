package kz.kbtu.webservice.controller;

import kz.kbtu.webservice.model.Quote;
import kz.kbtu.webservice.model.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomController {


    @GetMapping("/api/random")
    public Quote randomQuote() {
        return new Quote("Random Type",new Value(12L,"test"));
    }
}
