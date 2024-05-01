package com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_onlinetext;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteSubmissionAssignmentOnlineTextResponse {
    private final UUID submissionAssignmentOnlineTextId;
    private final String message;
}
