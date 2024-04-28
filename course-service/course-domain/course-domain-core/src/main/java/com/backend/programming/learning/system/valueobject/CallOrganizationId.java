package com.backend.programming.learning.system.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class CallOrganizationId extends BaseId<UUID> {
    public CallOrganizationId(UUID value) {
        super(value);
    }
}