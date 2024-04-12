package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class ContestUserId extends BaseId<UUID> {
    public ContestUserId(UUID value) {
        super(value);
    }
}
