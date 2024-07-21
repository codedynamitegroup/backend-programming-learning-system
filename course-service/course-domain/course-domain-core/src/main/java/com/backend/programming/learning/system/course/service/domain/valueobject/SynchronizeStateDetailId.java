package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class SynchronizeStateDetailId extends BaseId<UUID> {
    public SynchronizeStateDetailId(UUID value) {
        super(value);
    }
}
