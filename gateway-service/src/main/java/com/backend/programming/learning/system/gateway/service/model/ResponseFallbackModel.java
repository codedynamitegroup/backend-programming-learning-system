package com.backend.programming.learning.system.gateway.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseFallbackModel {
    private ZonedDateTime timestamp;
    private String path;
    private String status;
    private String error;
    private String message;
    private String requestId;
    private String trace;
}
