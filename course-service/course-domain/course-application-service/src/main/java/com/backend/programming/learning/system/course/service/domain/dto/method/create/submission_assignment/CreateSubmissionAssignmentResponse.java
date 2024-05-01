package com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateSubmissionAssignmentResponse {
    @NotNull
    private final UUID submissionId;

    @NotNull
    private final UUID userId;

    @NotNull
    private final UUID assignmentId;

    @NotNull
    private final String message;

}
