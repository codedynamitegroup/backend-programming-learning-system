package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class AnswerId extends BaseId<UUID> {
    public AnswerId(UUID value) {
        super(value);
    }
}
