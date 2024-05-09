package com.backend.programming.learning.system.code.assessment.service.domain.exeption.shared_solution;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class SharedSolutionNotFound extends DomainException {
    public SharedSolutionNotFound(String message) {
        super(message);
    }

    public SharedSolutionNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
