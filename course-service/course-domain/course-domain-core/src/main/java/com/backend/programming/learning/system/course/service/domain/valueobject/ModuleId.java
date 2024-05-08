package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class ModuleId extends BaseId<UUID> {
    public ModuleId(UUID value) {
        super(value);
    }
}
