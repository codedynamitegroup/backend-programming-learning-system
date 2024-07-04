package com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.AIGradeEssaySubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.SubmissionAssignmentResponseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryAllSubmissionAssignmentAIGradeEssayResponse {
    @JsonProperty("submissionAssignments")
    private List<AIGradeEssaySubmissionAssignmentResponseEntity> submissionAssignments;
    @NotNull
    @JsonProperty("totalItems")
    private long totalItems;
}
