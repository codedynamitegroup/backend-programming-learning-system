package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class ChapterId extends BaseId<UUID> {
    public ChapterId(UUID value) {
        super(value);
    }
}
