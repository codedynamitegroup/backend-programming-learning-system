package com.backend.programming.learning.system.course.service.domain.dto.method.query.ai_grade_essay_report;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.ai_grade_essay_report.AssignmentAIGradeReportEntityResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.rubric_user.RubricUserEntityResponse;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllAIGradeEssayReportsByAssignmentIdResponse {
    private final List<AssignmentAIGradeReportEntityResponse> aiGradeAssignmentReports;
    @NotNull
    private final int currentPage;
    @NotNull
    private final long totalItems;
    @NotNull
    private final int totalPages;
}
