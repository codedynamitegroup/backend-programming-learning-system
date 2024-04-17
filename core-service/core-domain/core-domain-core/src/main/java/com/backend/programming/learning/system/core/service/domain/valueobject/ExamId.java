package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class ExamId extends BaseId<UUID> {
    public ExamId(UUID value) {
        super(value);
    }
}
