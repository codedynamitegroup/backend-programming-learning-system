package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class ChapterResourceUserId extends BaseId<UUID> {
    public ChapterResourceUserId(UUID value) {
        super(value);
    }
}
