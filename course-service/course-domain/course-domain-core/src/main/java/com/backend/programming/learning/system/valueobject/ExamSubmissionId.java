package com.backend.programming.learning.system.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class ExamSubmissionId extends BaseId<UUID> {
    public ExamSubmissionId(UUID value) {
        super(value);
    }
}
