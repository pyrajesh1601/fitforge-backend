package com.fitforge.fitforge_ai.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
public class ErrorResponse
{
    private boolean success;
    private String message;
    private Map<String, String> errors;
    private LocalDateTime timestamp;
}
