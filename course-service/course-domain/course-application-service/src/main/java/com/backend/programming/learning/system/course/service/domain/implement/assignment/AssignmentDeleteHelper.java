package com.backend.programming.learning.system.course.service.domain.implement.assignment;

import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.exception.AssignmentNotFoundException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AssignmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class AssignmentDeleteHelper {
    private final AssignmentRepository assignmentRepository;

    public AssignmentDeleteHelper(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Transactional(readOnly = true)
    public void deleteAssignmentById(UUID assignmentId) {
        checkAssignmentExists(assignmentId);
        assignmentRepository.deleteAssignmentById(assignmentId);
    }

    private void checkAssignmentExists(UUID assignmentId) {
        Optional<Assignment> assignment = assignmentRepository.findById(assignmentId);
        if (assignment.isEmpty()) {
            log.warn("Could not find assignment with id: {}", assignmentId);
            throw new AssignmentNotFoundException("Could not find assignment with id: " + assignmentId);
        }
    }




}
