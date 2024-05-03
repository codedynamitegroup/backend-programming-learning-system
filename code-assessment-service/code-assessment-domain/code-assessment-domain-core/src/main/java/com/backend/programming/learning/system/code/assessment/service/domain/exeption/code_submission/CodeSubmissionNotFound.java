package com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_submission;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CodeSubmissionNotFound extends DomainException {
    public CodeSubmissionNotFound(String message) {
        super(message);
    }

    public CodeSubmissionNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}