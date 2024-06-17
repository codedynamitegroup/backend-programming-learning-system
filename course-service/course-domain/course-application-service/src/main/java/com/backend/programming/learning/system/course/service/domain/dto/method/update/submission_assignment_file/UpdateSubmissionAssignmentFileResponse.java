package com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment_file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateSubmissionAssignmentFileResponse {
    private final UUID id;
    private final String message;
}
