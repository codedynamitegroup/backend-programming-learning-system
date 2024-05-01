package com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment_onlinetext;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QuerySubmissionAssignmentOnlineTextResponse {
    private final UUID submissionAssignmentOnlineTextId;
    private final String message;
}
