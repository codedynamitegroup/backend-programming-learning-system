package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class OrganizationRoleId extends BaseId<UUID> {
    public OrganizationRoleId(UUID value) {
        super(value);
    }
}
