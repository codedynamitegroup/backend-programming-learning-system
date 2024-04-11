package com.backend.programming.learning.system.application.handler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {Exception.class})
    public ErrorDTO handleException(Exception exception) {
        log.error(exception.getMessage(), exception);

        return ErrorDTO.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message("Unexpected error occurred !!")
                .build();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {Exception.class})
    public ErrorDTO handleException(ValidationException validationException) {
        ErrorDTO errorDTO;

        // Extract the validation errors from the exception
        // Check if the exception is a type of ConstraintViolationException
        if(validationException instanceof ConstraintViolationException) {
            String violations = extractViolations((ConstraintViolationException) validationException);

            log.error(violations, validationException);

            errorDTO = ErrorDTO.builder()
                    .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .message(violations)
                    .build();
        }
        else {
            String exceptionMessage = validationException.getMessage();

            log.error(exceptionMessage, validationException);

            errorDTO = ErrorDTO.builder()
                    .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .message(exceptionMessage)
                    .build();
        }

        return errorDTO;
    }

    // Extract the validation errors from the exception
    // and join them using "--" then return them as a single string
    private String extractViolations(ConstraintViolationException validationException) {
        return validationException
                .getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("--"));
    }
}
