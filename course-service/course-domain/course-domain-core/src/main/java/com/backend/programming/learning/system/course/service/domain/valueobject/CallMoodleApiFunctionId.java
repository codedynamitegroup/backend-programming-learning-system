package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class CallMoodleApiFunctionId extends BaseId<UUID> {

    public CallMoodleApiFunctionId(UUID value) {
        super(value);
    }
}
