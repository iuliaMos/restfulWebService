package com.example;

import com.example.consumingrest.Quote;
import com.example.consumingrest.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuotationController {

    @GetMapping("/quote")
    public Quote getRandomQuote() {
        return new Quote("local", new Value(3l, "The best quote"));
    }
}
