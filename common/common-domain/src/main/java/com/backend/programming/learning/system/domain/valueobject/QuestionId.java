package com.backend.programming.learning.system.domain.valueobject;

import java.util.UUID;

public class QuestionId extends BaseId<UUID> {
    public QuestionId(UUID value) {
        super(value);
    }
}
