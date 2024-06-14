package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class AnswerOfQuestionId  extends BaseId<UUID> {
    public AnswerOfQuestionId(UUID value) {
        super(value);
    }
}
