package kz.kbtu.webservice.controller;

import kz.kbtu.webservice.model.Greeting;
import kz.kbtu.webservice.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    GreetingService greetingService = new GreetingService();


    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return greetingService.generateGreeting(name);

    }
}
