package kz.kbtu.webservice.service;

import kz.kbtu.webservice.model.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class GreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    public Greeting generateGreeting(String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
