package com.backend.programming.learning.system.auth.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class RoleId extends BaseId<UUID> {
    public RoleId(UUID value) {
        super(value);
    }
}
