package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class ContestId extends BaseId<UUID> {
    public ContestId(UUID value) {
        super(value);
    }
}
