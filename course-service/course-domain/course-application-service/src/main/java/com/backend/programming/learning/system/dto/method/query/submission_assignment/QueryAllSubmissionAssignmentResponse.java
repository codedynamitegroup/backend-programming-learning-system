package com.backend.programming.learning.system.dto.method.query.submission_assignment;

import com.backend.programming.learning.system.dto.responseentity.submission_assignment.SubmissionAssignmentResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllSubmissionAssignmentResponse {
    private final List<SubmissionAssignmentResponseEntity> submissionAssignments;
}
