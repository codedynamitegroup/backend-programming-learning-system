package com.backend.programming.learning.system.course.service.domain.mapper.ai_grade_essay_report;


import com.backend.programming.learning.system.course.service.domain.dto.method.query.ai_grade_essay_report.QueryAllAIGradeEssayReportsByAssignmentIdResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.rubric_user.QueryAllRubricsByUserIdResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.ai_grade_essay_report.AssignmentAIGradeReportEntityResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.rubric_user.RubricUserEntityResponse;
import com.backend.programming.learning.system.course.service.domain.entity.AssignmentAIGradeReport;
import com.backend.programming.learning.system.course.service.domain.entity.RubricUser;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AIGradeEssayReportDataMapper {
    public AssignmentAIGradeReportEntityResponse assignmentAIGradeReportToAssignmentAIGradeReportEntityResponse(AssignmentAIGradeReport assignmentAIGradeReport) {
        return AssignmentAIGradeReportEntityResponse.builder()
                .id(assignmentAIGradeReport.getId().getValue().toString())
                .status(assignmentAIGradeReport.getStatus())
                .question(assignmentAIGradeReport.getQuestion())
                .studentSubmissions(assignmentAIGradeReport.getStudentSubmissions())
                .feedbackSubmissions(assignmentAIGradeReport.getFeedbackSubmissions())
                .feedbackLanguage(assignmentAIGradeReport.getFeedbackLanguage())
                .createdAt(assignmentAIGradeReport.getCreatedAt())
                .build();
    }

    public QueryAllAIGradeEssayReportsByAssignmentIdResponse assignmentAIGradeReportsToQueryAllAIGradeEssayReportsByAssignmentId(Page<AssignmentAIGradeReport> assignmentAIGradeReports) {
        List<AssignmentAIGradeReportEntityResponse> assignmentAIGradeReportEntityResponses = assignmentAIGradeReports.getContent().stream().map(this::assignmentAIGradeReportToAssignmentAIGradeReportEntityResponse).toList();
        return QueryAllAIGradeEssayReportsByAssignmentIdResponse.builder()
                .aiGradeAssignmentReports(assignmentAIGradeReportEntityResponses)
                .currentPage(assignmentAIGradeReports.getNumber())
                .totalPages(assignmentAIGradeReports.getTotalPages())
                .totalItems(assignmentAIGradeReports.getTotalElements())
                .build();
    }
}
