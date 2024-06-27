package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AssignmentRepository {
    Assignment saveAssignment(Assignment assignment);

    Optional<Assignment> findById(UUID assignmentId);
    List<Assignment> findAllByCourseId(CourseId courseId);

    Optional<Assignment> findByAssignmentIdMoodle(Integer assignmentIdMoodle);

    void deleteAssignmentById(UUID assignmentId);

    List<Assignment> findAll();
    List<Assignment> findRecentAssignment();

    List<Assignment> findListGradeAssignmentByCourseId(UUID courseId, UUID userId);

    List<Assignment> findAllGradeStudentAssignment(UUID courseId);
}
