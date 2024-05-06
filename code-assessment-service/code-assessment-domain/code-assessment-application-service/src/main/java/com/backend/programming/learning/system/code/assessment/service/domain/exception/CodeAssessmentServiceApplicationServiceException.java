package com.backend.programming.learning.system.code.assessment.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CodeAssessmentServiceApplicationServiceException extends DomainException {

    public CodeAssessmentServiceApplicationServiceException(String message) {
        super(message);
    }

    public CodeAssessmentServiceApplicationServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
