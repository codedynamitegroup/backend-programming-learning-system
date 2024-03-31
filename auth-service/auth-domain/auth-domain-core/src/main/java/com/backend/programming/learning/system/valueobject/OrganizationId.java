package com.backend.programming.learning.system.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class OrganizationId extends BaseId<UUID> {
    public OrganizationId(UUID value) {
        super(value);
    }
}
