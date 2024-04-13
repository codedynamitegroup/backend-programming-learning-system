package com.backend.programming.learning.system.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class AssignmentSubmissionId extends BaseId<UUID> {
    public AssignmentSubmissionId(UUID value) {
        super(value);
    }
}
