package com.example.springstreamexample.web.rest;

import com.example.springstreamexample.domain.Greeting;
import com.example.springstreamexample.service.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController("/greetings")
public class GreetingResource {

    private final GreetingService greetingService;

    public GreetingResource(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendGreeting(@RequestBody HashMap<String, String> body) {
        Greeting greeting = Greeting.builder()
                .message(body.get("message"))
                .timestamp(System.currentTimeMillis())
                .build();
        greetingService.sendGreeting(greeting);
    }
}
