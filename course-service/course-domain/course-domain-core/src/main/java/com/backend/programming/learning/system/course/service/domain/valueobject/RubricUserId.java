package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class RubricUserId extends BaseId<UUID> {
    public RubricUserId(UUID value) {
        super(value);
    }
}
