package com.example.springstreamexample.listener;

import com.example.springstreamexample.domain.Greeting;
import com.example.springstreamexample.stream.GreetingStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GreetingListener {

    @StreamListener(GreetingStream.INPUT)
    public void handleGreeting(@Payload Greeting greeting) {
        log.info("Received greeting: {}", greeting);
    }
}
