package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.AssignmentAIGradeReport;
import com.backend.programming.learning.system.course.service.domain.entity.RubricUser;
import com.backend.programming.learning.system.domain.valueobject.AssignmentAIGradeReportStatus;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AssignmentAIGradeReportRepository {
    AssignmentAIGradeReport save(AssignmentAIGradeReport rubricUser);
    Optional<AssignmentAIGradeReport> findByReportId(UUID reportId);
    List<AssignmentAIGradeReport> findByStatus(AssignmentAIGradeReportStatus assignmentAIGradeReportStatus);

    Page<AssignmentAIGradeReport> findAllByAssignmentId(UUID assignmentId, int pageNo, int pageSize, String search);
}
