package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class SectionId extends BaseId<UUID> {
    public SectionId(UUID value) {
        super(value);
    }
}
