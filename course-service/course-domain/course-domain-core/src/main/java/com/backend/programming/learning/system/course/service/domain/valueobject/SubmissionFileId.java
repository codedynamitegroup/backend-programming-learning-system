package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class SubmissionFileId extends BaseId<UUID> {
    public SubmissionFileId(UUID value) {
        super(value);
    }
}
