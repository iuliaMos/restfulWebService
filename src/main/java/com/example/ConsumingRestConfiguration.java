package com.example;

import com.example.consumingrest.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConsumingRestConfiguration {

    private static final Logger log = LoggerFactory.getLogger(ConsumingRestConfiguration.class);

    @Value("${quotation.url}")
    private String quotationUrl;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    @ConditionalOnProperty(
            value = "server.port",
            havingValue = "8080"
    )
    public CommandLineRunner commandLineRunner(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(quotationUrl, Quote.class);
            log.info(quote.toString());
        };
    }
}
