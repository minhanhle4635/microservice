package com.example.productservice.controller.dto.response;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse implements Serializable {
    private final LocalDateTime timestamp = LocalDateTime.now();
    protected int code;
    protected String message;
    private List<String> details;
}

