package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class ContestQuestionId extends BaseId<UUID> {
    public ContestQuestionId(UUID value) {
        super(value);
    }
}
