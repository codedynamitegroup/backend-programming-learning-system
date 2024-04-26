package com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateSubmissionAssignmentFileResponse {
    private final UUID submissionAssignmentFileId;
    private final String message;
}
