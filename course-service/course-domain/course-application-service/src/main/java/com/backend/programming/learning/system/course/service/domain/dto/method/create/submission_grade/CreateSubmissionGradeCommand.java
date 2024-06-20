package com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_grade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateSubmissionGradeCommand {
    private final UUID submissionAssignmentId;
    private final Float grade;
    private final ZonedDateTime timeCreated;
    private final ZonedDateTime timeModified;
}
