package com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_submission;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CodeSubmissionJudgingServiceUnavailableException extends DomainException {
    public CodeSubmissionJudgingServiceUnavailableException(String message) {
        super(message);
    }

    public CodeSubmissionJudgingServiceUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
