package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class QuestionBankCategoryId extends BaseId<UUID> {
    public QuestionBankCategoryId(UUID value) {
        super(value);
    }
}
