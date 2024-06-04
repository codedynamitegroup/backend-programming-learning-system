package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class SubmissionGradeId extends BaseId<UUID> {
    public SubmissionGradeId(UUID value) {
        super(value);
    }
}
