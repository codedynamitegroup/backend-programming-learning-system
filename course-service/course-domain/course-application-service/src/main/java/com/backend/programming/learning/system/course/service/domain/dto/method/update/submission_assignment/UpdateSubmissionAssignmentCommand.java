package com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateSubmissionAssignmentCommand {
    private final Boolean isGraded;

    private final Float grade;

    private final String content;
    private final String feedback;

    private final ZonedDateTime timemodified;

}