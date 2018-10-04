package com.example.springstreamexample.config;

import com.example.springstreamexample.stream.GreetingStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(GreetingStream.class)
public class StreamConfig {
}
