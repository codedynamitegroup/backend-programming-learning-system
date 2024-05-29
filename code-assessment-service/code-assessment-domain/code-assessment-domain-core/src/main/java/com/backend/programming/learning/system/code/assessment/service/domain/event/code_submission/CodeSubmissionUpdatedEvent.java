package com.backend.programming.learning.system.code.assessment.service.domain.event.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.domain.event.DomainEvent;

import java.time.ZonedDateTime;

public class CodeSubmissionUpdatedEvent implements DomainEvent<CodeSubmission> {
    final CodeSubmission codeSubmission;
    final ZonedDateTime createdAt;

    public CodeSubmissionUpdatedEvent(CodeSubmission codeSubmission, ZonedDateTime createdAt) {
        this.codeSubmission = codeSubmission;
        this.createdAt = createdAt;
    }

    public CodeSubmission getCodeSubmission() {
        return codeSubmission;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public void fire() {

    }
}
