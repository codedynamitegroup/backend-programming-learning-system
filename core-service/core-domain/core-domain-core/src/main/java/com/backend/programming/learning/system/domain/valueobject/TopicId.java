package com.backend.programming.learning.system.domain.valueobject;

import java.util.UUID;

public class TopicId extends BaseId<UUID> {
    public TopicId(UUID value) {
        super(value);
    }
}
