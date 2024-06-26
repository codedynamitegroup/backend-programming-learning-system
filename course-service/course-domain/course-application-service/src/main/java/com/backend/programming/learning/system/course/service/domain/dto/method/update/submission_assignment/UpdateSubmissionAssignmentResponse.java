package com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateSubmissionAssignmentResponse {
    private final UUID id;
    private final String message;
}
