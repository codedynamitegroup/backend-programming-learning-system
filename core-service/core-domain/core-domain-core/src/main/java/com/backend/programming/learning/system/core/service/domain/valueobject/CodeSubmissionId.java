package com.backend.programming.learning.system.core.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class CodeSubmissionId extends BaseId<UUID> {
    public CodeSubmissionId(UUID value) {
        super(value);
    }
}
