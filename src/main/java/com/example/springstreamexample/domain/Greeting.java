package com.example.springstreamexample.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Greeting {

    private long timestamp;
    private String message;
}
