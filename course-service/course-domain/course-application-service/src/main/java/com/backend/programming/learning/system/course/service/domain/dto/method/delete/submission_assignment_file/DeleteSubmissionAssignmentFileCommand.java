package com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_file;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteSubmissionAssignmentFileCommand {
    @NotNull
    private final UUID id;
}
