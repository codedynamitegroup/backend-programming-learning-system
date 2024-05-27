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
    private final UUID submissionAssignmentId;

    @NotNull
    private final Boolean isGraded;

    @NotNull
    private final Float grade;

    @NotNull
    private final String content;

    @NotNull
    private final ZonedDateTime timeSubmit;

}