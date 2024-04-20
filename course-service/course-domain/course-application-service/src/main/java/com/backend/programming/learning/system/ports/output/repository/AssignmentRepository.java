package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Assignment;
import com.backend.programming.learning.system.valueobject.CourseId;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AssignmentRepository {
    Assignment saveAssignment(Assignment assignment);

    Optional<Assignment> findById(UUID assignmentId);
    List<Assignment> findAllByCourseId(CourseId courseId);

    void deleteAssignmentById(UUID assignmentId);

    int updateAssignment(Assignment assignment);

}
