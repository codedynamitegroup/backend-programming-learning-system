package com.backend.programming.learning.system.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class QuestionSubmissionId extends BaseId<UUID> {
    public QuestionSubmissionId(UUID value) {
        super(value);
    }
}
