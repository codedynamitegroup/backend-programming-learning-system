package com.backend.programming.learning.system.dto.method.delete.submission_assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteSubmissionAssignmentCommand {
    @NotNull
    private final UUID submissionAssignmentId;

}
