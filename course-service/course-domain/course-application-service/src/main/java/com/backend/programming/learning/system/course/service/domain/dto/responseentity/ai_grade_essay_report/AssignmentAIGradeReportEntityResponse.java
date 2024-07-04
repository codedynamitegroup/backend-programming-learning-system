package com.backend.programming.learning.system.course.service.domain.dto.responseentity.ai_grade_essay_report;

import com.backend.programming.learning.system.course.service.domain.entity.RubricUser;
import com.backend.programming.learning.system.domain.valueobject.AssignmentAIGradeReportStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class AssignmentAIGradeReportEntityResponse {
    private String id;
    private AssignmentAIGradeReportStatus status;

    private String question;
    private String studentSubmissions;
    private String feedbackSubmissions;
    private String feedbackLanguage;
    private ZonedDateTime createdAt;
}
