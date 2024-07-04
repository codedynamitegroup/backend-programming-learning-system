package com.backend.programming.learning.system.course.service.domain.valueobject;

import com.backend.programming.learning.system.domain.valueobject.BaseId;

import java.util.UUID;

public class AssignmentAIGradeReportId extends BaseId<UUID> {
    public AssignmentAIGradeReportId(UUID value) {
        super(value);
    }
}
