package com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QuerySubmissionAssignmentUserCommand {
    private final UUID assignmentId;
    private final UUID userId;
}
