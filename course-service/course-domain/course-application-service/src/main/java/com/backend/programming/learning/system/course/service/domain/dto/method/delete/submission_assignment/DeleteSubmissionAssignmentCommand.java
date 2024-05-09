package com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteSubmissionAssignmentCommand {
    @NotNull
    private final UUID submissionAssignmentId;

}
