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
    private Integer code;
    private String status;
    private String message;
    private ZonedDateTime timestamp;
    private String path;
    private String requestId;
    private String trace;
}
