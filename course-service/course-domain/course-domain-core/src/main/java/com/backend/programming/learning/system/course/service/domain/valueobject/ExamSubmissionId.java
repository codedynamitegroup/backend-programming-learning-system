package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class ExamSubmissionId extends BaseId<UUID> {
    public ExamSubmissionId(UUID value) {
        super(value);
    }
}
