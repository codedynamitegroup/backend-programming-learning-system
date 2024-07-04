package com.backend.programming.learning.system.course.service.dataaccess.assignment_ai_grade_report.repository;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_ai_grade_report.entity.AssignmentAIGradeReportEntity;
import com.backend.programming.learning.system.course.service.dataaccess.rubric_user.entity.RubricUserEntity;
import com.backend.programming.learning.system.course.service.domain.entity.AssignmentAIGradeReport;
import com.backend.programming.learning.system.domain.valueobject.AssignmentAIGradeReportStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AssignmentAIGradeReportJpaRepository extends JpaRepository<AssignmentAIGradeReportEntity, UUID> {
     List<AssignmentAIGradeReportEntity> findByStatus(AssignmentAIGradeReportStatus assignmentAIGradeReportStatus);

     @Query(value = """
        select aigr.*
        from assignment_ai_grade_report aigr
        join public.assignment a ON aigr.assignment_id = a.id
        where aigr.assignment_id = ?1
        """, nativeQuery = true)
     Page<AssignmentAIGradeReportEntity> findAllByAssignmentId(UUID assignmentId, String search, Pageable paging);
}
