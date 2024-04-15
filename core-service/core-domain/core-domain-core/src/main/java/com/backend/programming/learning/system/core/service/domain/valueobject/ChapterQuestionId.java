package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class ChapterQuestionId extends BaseId<UUID> {
    public ChapterQuestionId(UUID value) {
        super(value);
    }
}
