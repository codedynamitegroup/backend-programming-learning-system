package com.backend.programming.learning.system.code.assessment.service.domain.exeption.shared_solution.comment;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CommentNotFoundException extends DomainException {
    public CommentNotFoundException(String message) {
        super(message);
    }

    public CommentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
