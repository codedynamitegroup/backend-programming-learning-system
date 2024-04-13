package com.backend.programming.learning.system.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class ExamQuestionId extends BaseId<UUID> {
    public ExamQuestionId(UUID value) {
        super(value);
    }
}
