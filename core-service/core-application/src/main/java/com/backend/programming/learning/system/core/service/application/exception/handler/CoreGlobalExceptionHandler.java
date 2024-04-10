package com.backend.programming.learning.system.core.service.application.exception.handler;

import com.backend.programming.learning.system.application.handler.ErrorDTO;
import com.backend.programming.learning.system.application.handler.GlobalExceptionHandler;
import com.backend.programming.learning.system.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.domain.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class CoreGlobalExceptionHandler extends GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {CoreDomainException.class})
    @ResponseBody
    public ErrorDTO handleException(CoreDomainException coreDomainException) {
        log.error(coreDomainException.getMessage(), coreDomainException);
        return ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(coreDomainException.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {CoreDomainException.class})
    @ResponseBody
    public ErrorDTO handleException(UserNotFoundException userNotFoundException) {
        log.error(userNotFoundException.getMessage(), userNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(userNotFoundException.getMessage())
                .build();
    }
}
