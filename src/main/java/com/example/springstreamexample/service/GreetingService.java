package com.example.springstreamexample.service;

import com.example.springstreamexample.domain.Greeting;
import com.example.springstreamexample.stream.GreetingStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
public class GreetingService {

    private final GreetingStream greetingStream;

    public GreetingService(GreetingStream greetingStream) {
        this.greetingStream = greetingStream;
    }

    public void sendGreeting(Greeting greeting) {
        log.info("Sending Greeting {}", greeting);
        MessageChannel messageChannel = greetingStream.outboundGreetings();
        messageChannel.send(MessageBuilder
                .withPayload(greeting)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
