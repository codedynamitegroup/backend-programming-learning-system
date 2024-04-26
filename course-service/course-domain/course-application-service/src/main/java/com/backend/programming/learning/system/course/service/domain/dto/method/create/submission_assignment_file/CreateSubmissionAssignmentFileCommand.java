package com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateSubmissionAssignmentFileCommand {
    @NotNull
    private final UUID submissionAssignmentId;

    @NotNull
    private final int num_file;
}
