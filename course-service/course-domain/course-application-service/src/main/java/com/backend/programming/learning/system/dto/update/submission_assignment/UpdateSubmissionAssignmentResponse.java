package com.backend.programming.learning.system.dto.update.submission_assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateSubmissionAssignmentResponse {
    private final UUID submissionId;
    private final String message;
}
