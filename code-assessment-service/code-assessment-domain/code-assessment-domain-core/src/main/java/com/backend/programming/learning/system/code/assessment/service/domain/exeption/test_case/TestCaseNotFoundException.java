package com.backend.programming.learning.system.code.assessment.service.domain.exeption.test_case;

import com.backend.programming.learning.system.domain.exception.DomainException;


public class TestCaseNotFoundException extends DomainException {
    public TestCaseNotFoundException(String message) {
        super(message);
    }

    public TestCaseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}