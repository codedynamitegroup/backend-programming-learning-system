package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class QuestionSubmissionFileId extends BaseId<UUID> {
    public QuestionSubmissionFileId(UUID value) {
        super(value);
    }
}