package com.backend.programming.learning.system.course.service.domain.dto.method.update.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateAssignmentResponse {
    private final UUID assignmentId;
    private final String message;
}
