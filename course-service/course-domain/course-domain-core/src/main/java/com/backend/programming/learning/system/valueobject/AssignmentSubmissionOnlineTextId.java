package com.backend.programming.learning.system.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class AssignmentSubmissionOnlineTextId extends BaseId<UUID> {
    public AssignmentSubmissionOnlineTextId(UUID value) {
        super(value);
    }
}
