package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class SubmissionAssignmentId extends BaseId<UUID> {
    public SubmissionAssignmentId(UUID value) {
        super(value);
    }
}
