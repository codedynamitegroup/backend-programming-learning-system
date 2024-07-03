package com.backend.programming.learning.system.course.service.dataaccess.assignment_ai_grade_report.repository;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_ai_grade_report.entity.AssignmentAIGradeReportEntity;
import com.backend.programming.learning.system.course.service.domain.entity.AssignmentAIGradeReport;
import com.backend.programming.learning.system.domain.valueobject.AssignmentAIGradeReportStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AssignmentAIGradeReportJpaRepository extends JpaRepository<AssignmentAIGradeReportEntity, UUID> {
     List<AssignmentAIGradeReportEntity> findByStatus(AssignmentAIGradeReportStatus assignmentAIGradeReportStatus);
}
