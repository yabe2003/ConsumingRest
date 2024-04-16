package com.example.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestApplication {

    private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

    // Directly specify the base URL here
    private final String baseUrl = "http://localhost:8080";

    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            // Fetch random quote
            fetchQuote(restTemplate, "/api/random");

            // Fetch specific quotes
            fetchQuote(restTemplate, "/api/1");
            fetchQuote(restTemplate, "/api/2");
            fetchQuote(restTemplate, "/api/3");
        };
    }

    private void fetchQuote(RestTemplate restTemplate, String path) {
        try {
            Quote quote = restTemplate.getForObject(baseUrl + path, Quote.class);
            log.info(quote.toString());
        } catch (Exception e) {
            log.error("Failed to fetch quote from " + path, e);
        }
    }
}
