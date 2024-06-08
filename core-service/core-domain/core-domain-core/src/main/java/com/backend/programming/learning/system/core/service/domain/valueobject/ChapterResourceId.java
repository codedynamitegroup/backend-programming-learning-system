package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class ChapterResourceId extends BaseId<UUID> {
    public ChapterResourceId(UUID value) {
        super(value);
    }
}
