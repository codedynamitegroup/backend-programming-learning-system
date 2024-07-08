package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class SynchronizeStateId extends BaseId<UUID> {
    public SynchronizeStateId(UUID value) {
        super(value);
    }
}
