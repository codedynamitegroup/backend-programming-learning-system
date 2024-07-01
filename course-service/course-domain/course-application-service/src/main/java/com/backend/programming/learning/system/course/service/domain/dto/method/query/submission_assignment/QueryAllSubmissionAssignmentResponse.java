package com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.SubmissionAssignmentResponseEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllSubmissionAssignmentResponse {
    private final List<SubmissionAssignmentResponseEntity> submissionAssignments;
    @NotNull
    private final int currentPage;
    @NotNull
    private final long totalItems;
    @NotNull
    private final int totalPages;
}
