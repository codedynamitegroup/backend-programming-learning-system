package com.backend.programming.learning.system.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class SubmissionAssignmentOnlineTextId extends BaseId<UUID> {
    public SubmissionAssignmentOnlineTextId(UUID value) {
        super(value);
    }
}
