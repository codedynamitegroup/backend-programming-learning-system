package com.backend.programming.learning.system.course.service.dataaccess.assignment_ai_grade_report.entity;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.role_moodle.entity.RoleMoodleEntity;
import com.backend.programming.learning.system.course.service.dataaccess.rubric_user.entity.RubricUserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.domain.valueobject.AssignmentAIGradeReportStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "assignment_ai_grade_report", schema = "public")
public class AssignmentAIGradeReportEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    private AssignmentAIGradeReportStatus status;

    private String question;
    private String studentSubmissions;
    private String feedbackSubmissions;

    @ManyToOne
    @JoinColumn(name = "rubric_id", referencedColumnName = "id")
    private RubricUserEntity rubricUser;

    private ZonedDateTime createdAt;
}