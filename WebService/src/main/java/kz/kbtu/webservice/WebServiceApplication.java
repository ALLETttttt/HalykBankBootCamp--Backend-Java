package kz.kbtu.webservice;

import kz.kbtu.webservice.model.Quote;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
public class WebServiceApplication {

    //Spring IoC -> Spring Inversion of Control

    private static final Logger log = (Logger) LoggerFactory.getLogger(WebServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "http://localhost:8080/api/random", Quote.class);
            log.info(quote.toString());
        };
    }
}
