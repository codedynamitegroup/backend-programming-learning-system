package com.backend.programming.learning.system.application.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorDTO {
    private final Integer code;
    private final String status;
    private final String message;
}
