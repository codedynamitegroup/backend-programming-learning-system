package com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;
@Getter
@Builder
@AllArgsConstructor
public class SubmissionAssignmentResponseEntity {
    private final UUID submissionAssignmentId;
    private final UUID userId;
    private final UUID questionId;
    private final Integer pass_status;
    private final Float grade;
    private final String content;
    private final ZonedDateTime submitTime;
}
