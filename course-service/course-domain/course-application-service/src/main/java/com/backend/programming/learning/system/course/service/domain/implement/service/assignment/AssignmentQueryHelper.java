package com.backend.programming.learning.system.course.service.domain.implement.service.assignment;

import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.exception.AssignmentNotFoundException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AssignmentRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class AssignmentQueryHelper {
    private final AssignmentRepository assignmentRepository;

    public AssignmentQueryHelper(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Transactional(readOnly = true)
    public List<Assignment> queryAllAssignments(UUID courseId) {
        return assignmentRepository.findAllByCourseId(new CourseId(courseId));
    }

    @Transactional(readOnly = true)
    public Assignment queryAssignmentById(UUID assignmentId) {
        Optional<Assignment> assignment = assignmentRepository.
                findById(assignmentId);
        if (assignment.isEmpty()) {
            log.error("Assignment not found with id: {}", assignmentId);
            throw new AssignmentNotFoundException("Assignment not found with id: " + assignmentId);
        }

        log.info("Assignment queried with id: {}", assignmentId);
        return assignment.get();
    }

    @Transactional(readOnly = true)
    public List<Assignment> queryAssignmentGrade(UUID courseId, UUID userId, String searchName, Integer page, Integer size) {
        return assignmentRepository.findListGradeAssignmentByCourseId(courseId, userId, searchName, page, size);
    }

    @Transactional(readOnly = true)
    public List<Assignment> findAllGradeStudentAssignment(UUID courseId) {
        return assignmentRepository.findAllGradeStudentAssignment(courseId);
    }


}
