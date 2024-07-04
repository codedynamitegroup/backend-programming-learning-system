package com.backend.programming.learning.system.course.service.dataaccess.assignment_ai_grade_report.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.mapper.AssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_ai_grade_report.entity.AssignmentAIGradeReportEntity;
import com.backend.programming.learning.system.course.service.dataaccess.rubric_user.mapper.RubricUserDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.domain.entity.AssignmentAIGradeReport;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.AssignmentAIGradeReportId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AssignmentAIGradeReportDataAccessMapper {
    private final RubricUserDataAccessMapper rubricUserDataAccessMapper;
    private final AssignmentDataAccessMapper assignmentDataAccessMapper;

    public AssignmentAIGradeReportEntity assignmentAIGradeReportToAssignmentAIGradeReportEntity(AssignmentAIGradeReport assignmentAIGradeReport) {
        return AssignmentAIGradeReportEntity.builder()
                .id(assignmentAIGradeReport.getId().getValue())
                .createdAt(assignmentAIGradeReport.getCreatedAt())
                .feedbackSubmissions(assignmentAIGradeReport.getFeedbackSubmissions())
                .question(assignmentAIGradeReport.getQuestion())
                .rubricUser(assignmentAIGradeReport.getRubricUser() == null ? null : rubricUserDataAccessMapper.rubricUserToRubricUserEntity(assignmentAIGradeReport.getRubricUser()))
                .studentSubmissions(assignmentAIGradeReport.getStudentSubmissions())
                .feedbackLanguage(assignmentAIGradeReport.getFeedbackLanguage())
                .status(assignmentAIGradeReport.getStatus())
                .assignment(assignmentAIGradeReport.getAssignment() == null ? null : assignmentDataAccessMapper.assignmentToAssignmentEntity(assignmentAIGradeReport.getAssignment()))
                .build();
    }

    public AssignmentAIGradeReport assignmentAIGradeReportEntityToAssignmentAIGradeReport(AssignmentAIGradeReportEntity assignmentAIGradeReportEntity) {
        return AssignmentAIGradeReport.builder()
                .id(new AssignmentAIGradeReportId(assignmentAIGradeReportEntity.getId()))
                .createdAt(assignmentAIGradeReportEntity.getCreatedAt())
                .feedbackSubmissions(assignmentAIGradeReportEntity.getFeedbackSubmissions())
                .question(assignmentAIGradeReportEntity.getQuestion())
                .rubricUser(assignmentAIGradeReportEntity.getRubricUser() == null ? null : rubricUserDataAccessMapper.rubricUserEntityToRubricUser(assignmentAIGradeReportEntity.getRubricUser()))
                .studentSubmissions(assignmentAIGradeReportEntity.getStudentSubmissions())
                .status(assignmentAIGradeReportEntity.getStatus())
                .feedbackLanguage(assignmentAIGradeReportEntity.getFeedbackLanguage())
                .assignment(assignmentAIGradeReportEntity.getAssignment() == null ? null : assignmentDataAccessMapper.assignmentEntityToAssignment(assignmentAIGradeReportEntity.getAssignment()))
                .build();

    }
}
