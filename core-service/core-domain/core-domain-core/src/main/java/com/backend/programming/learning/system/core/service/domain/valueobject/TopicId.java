package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class TopicId extends BaseId<UUID> {
    public TopicId(UUID value) {
        super(value);
    }
}
