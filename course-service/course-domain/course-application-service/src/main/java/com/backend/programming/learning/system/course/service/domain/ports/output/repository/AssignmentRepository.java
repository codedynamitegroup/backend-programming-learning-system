package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AssignmentRepository {
    Assignment saveAssignment(Assignment assignment);

    Optional<Assignment> findById(UUID assignmentId);
    List<Assignment> findAllByCourseId(CourseId courseId);

    Optional<Assignment> findByAssignmentIdMoodleAndCourseId(Integer assignmentIdMoodle, UUID courseId);

    void deleteAssignmentById(UUID assignmentId);

    List<Assignment> findAll();
    List<Assignment> findRecentAssignment();

    List<Assignment> findListGradeAssignmentByCourseId(UUID courseId, UUID userId, String searchName, Integer page, Integer size);
    List<Assignment> findAllGradeStudentAssignment(UUID courseId);
}
