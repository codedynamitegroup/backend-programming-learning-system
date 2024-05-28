package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class IntroFileId extends BaseId<UUID> {
    public IntroFileId(UUID value) {
        super(value);
    }
}
