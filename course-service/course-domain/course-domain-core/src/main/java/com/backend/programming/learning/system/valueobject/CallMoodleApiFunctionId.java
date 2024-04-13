package com.backend.programming.learning.system.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class CallMoodleApiFunctionId extends BaseId<UUID> {

    public CallMoodleApiFunctionId(UUID value) {
        super(value);
    }
}
