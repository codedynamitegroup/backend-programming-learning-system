package com.backend.programming.learning.system.code.assessment.service.domain.exeption;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CodeAssessmentDomainException extends DomainException {
    public CodeAssessmentDomainException(String message) {
        super(message);
    }

    public CodeAssessmentDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
