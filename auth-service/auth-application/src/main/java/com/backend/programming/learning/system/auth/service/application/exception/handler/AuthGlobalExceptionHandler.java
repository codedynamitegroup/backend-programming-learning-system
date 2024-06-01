package com.backend.programming.learning.system.auth.service.application.exception.handler;

import com.backend.programming.learning.system.application.handler.ErrorDTO;
import com.backend.programming.learning.system.application.handler.GlobalExceptionHandler;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.exception.ForbiddenServiceException;
import com.backend.programming.learning.system.auth.service.domain.exception.UnAuthorizedServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class AuthGlobalExceptionHandler extends GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = {AuthDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(AuthDomainException authDomainException) {
        log.error(authDomainException.getMessage(), authDomainException);
        return ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(authDomainException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {AuthNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(AuthNotFoundException authNotFoundException) {
        log.error(authNotFoundException.getMessage(), authNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(authNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {UnAuthorizedServiceException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorDTO handleException(UnAuthorizedServiceException unAuthorizedServiceException) {
        log.error(unAuthorizedServiceException.getMessage(), unAuthorizedServiceException);
        return ErrorDTO.builder()
                .code(HttpStatus.UNAUTHORIZED.value())
                .status(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .message(unAuthorizedServiceException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {ForbiddenServiceException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorDTO handleException(ForbiddenServiceException forbiddenServiceException) {
        log.error(forbiddenServiceException.getMessage(), forbiddenServiceException);
        return ErrorDTO.builder()
                .code(HttpStatus.FORBIDDEN.value())
                .status(HttpStatus.FORBIDDEN.getReasonPhrase())
                .message(forbiddenServiceException.getMessage())
                .build();
    }
}

