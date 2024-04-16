package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class TopicProgrammingLanguageId extends BaseId<UUID> {
    public TopicProgrammingLanguageId(UUID value) {
        super(value);
    }
}
