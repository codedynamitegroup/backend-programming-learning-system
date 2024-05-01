package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class SubmissionAssignmentOnlineTextId extends BaseId<UUID> {
    public SubmissionAssignmentOnlineTextId(UUID value) {
        super(value);
    }
}
