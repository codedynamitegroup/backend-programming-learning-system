package com.backend.programming.learning.system.code.assessment.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class SharedSolutionId extends BaseId<UUID> {
    public SharedSolutionId(UUID value) {
        super(value);
    }
}
