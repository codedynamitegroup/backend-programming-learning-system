package com.backend.programming.learning.system.core.service.application.exception.handler;

import com.backend.programming.learning.system.application.handler.ErrorDTO;
import com.backend.programming.learning.system.application.handler.GlobalExceptionHandler;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.OrganizationNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.question.QuestionNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class CoreGlobalExceptionHandler extends GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = {CoreDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(CoreDomainException orderDomainException) {
        log.error(orderDomainException.getMessage(), orderDomainException);
        return ErrorDTO.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(orderDomainException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {QuestionNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(QuestionNotFoundException questionNotFoundException) {
        log.error(questionNotFoundException.getMessage(), questionNotFoundException);
        return ErrorDTO.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(questionNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {CertificateCourseNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(CertificateCourseNotFoundException certificateCourseNotFoundException) {
        log.error(certificateCourseNotFoundException.getMessage(), certificateCourseNotFoundException);
        return ErrorDTO.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(certificateCourseNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {UserNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(UserNotFoundException userNotFoundException) {
        log.error(userNotFoundException.getMessage(), userNotFoundException);
        return ErrorDTO.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(userNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {OrganizationNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(OrganizationNotFoundException organizationNotFoundException) {
        log.error(organizationNotFoundException.getMessage(), organizationNotFoundException);
        return ErrorDTO.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(organizationNotFoundException.getMessage())
                .build();
    }
}

