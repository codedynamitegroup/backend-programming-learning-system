package com.backend.programming.learning.system.auth.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class UserRoleId  extends BaseId<UUID> {
    public UserRoleId(UUID value) {
        super(value);
    }
}
