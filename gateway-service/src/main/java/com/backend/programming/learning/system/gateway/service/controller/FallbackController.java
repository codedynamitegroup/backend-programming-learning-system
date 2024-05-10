package com.backend.programming.learning.system.gateway.service.controller;

import com.backend.programming.learning.system.gateway.service.model.ResponseFallbackModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.CIRCUITBREAKER_EXECUTION_EXCEPTION_ATTR;

@Slf4j
@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/core-fallback")
    public ResponseEntity<ResponseFallbackModel> coreServiceFallback(ServerWebExchange exchange) {
        return getResponseFallbackModel(exchange, "core-service");
    }

    @RequestMapping("/course-fallback")
    public ResponseEntity<ResponseFallbackModel> courseServiceFallback(ServerWebExchange exchange) {
        return getResponseFallbackModel(exchange, "course-service");
    }

    @RequestMapping("/auth-fallback")
    public ResponseEntity<ResponseFallbackModel> authServiceFallback(ServerWebExchange exchange) {
        return getResponseFallbackModel(exchange, "auth-service");
    }

    @RequestMapping("/code-assessment-fallback")
    public ResponseEntity<ResponseFallbackModel> codeAssessmentServiceFallback(ServerWebExchange exchange) {
        return getResponseFallbackModel(exchange, "code-assessment-service");
    }

    private ResponseEntity<ResponseFallbackModel> getResponseFallbackModel(ServerWebExchange exchange, String serviceName) {
        log.info("Returning fallback result for {}-service! on port {}", serviceName, port);
        Throwable cause = exchange.getAttribute(CIRCUITBREAKER_EXECUTION_EXCEPTION_ATTR);
        Throwable rootCause = ExceptionUtils.getRootCause(cause);
        log.debug("Failure, cause was : ", cause);

        if(rootCause == null && cause instanceof java.util.concurrent.TimeoutException) {
            // Gateway Timeout
            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(ResponseFallbackModel.builder()
                    .timestamp(ZonedDateTime.now(ZoneId.of("UTC")))
                    .path(exchange.getRequest().getPath().value())
                    .status(String.valueOf(HttpStatus.GATEWAY_TIMEOUT.value()))
                    .error(HttpStatus.GATEWAY_TIMEOUT.getReasonPhrase())
                    .message("The server took too long to respond.")
                    .requestId(exchange.getRequest().getId())
                    .trace(cause.getMessage())
                    .build());
        } else {
            // Other error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseFallbackModel.builder()
                    .timestamp(ZonedDateTime.now(ZoneId.of("UTC")))
                    .path(exchange.getRequest().getPath().value())
                    .status(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                    .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                    .message("An error occurred. Please try after some time or contact support team!!!")
                    .requestId(exchange.getRequest().getId())
                    .trace(cause != null ? cause.getMessage() : null)
                    .build());
        }
    }

}
