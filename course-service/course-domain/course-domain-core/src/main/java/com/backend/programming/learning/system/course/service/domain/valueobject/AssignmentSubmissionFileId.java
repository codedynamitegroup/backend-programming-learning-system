package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class AssignmentSubmissionFileId extends BaseId<UUID> {
    public AssignmentSubmissionFileId(UUID value) {
        super(value);
    }
}
