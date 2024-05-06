package com.backend.programming.learning.system.code.assessment.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CodeAssessmentApplicationServiceException extends DomainException {
    public CodeAssessmentApplicationServiceException(String message) {
        super(message);
    }

    public CodeAssessmentApplicationServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
