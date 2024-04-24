package com.backend.programming.learning.system.implement.submission_assignment;

import com.backend.programming.learning.system.entity.SubmissionAssignment;
import com.backend.programming.learning.system.exception.SubmissionAssignmentNotFoundException;
import com.backend.programming.learning.system.ports.output.repository.AssignmentRepository;
import com.backend.programming.learning.system.ports.output.repository.SubmissionAssignmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SubmissionAssignmentDeleteHelper {

    private final SubmissionAssignmentRepository submissionAssignmentRepository;

    @Transactional(readOnly = true)
    public void deleteSubmissionAssignmentById(UUID submissionAssignmentId) {
        checkSubmissionAssignmentExists(submissionAssignmentId);
        submissionAssignmentRepository.deleteSubmissionAssignmentById(submissionAssignmentId);
    }

    private void checkSubmissionAssignmentExists(UUID submissionAssignmentId) {
        Optional<SubmissionAssignment> submissionAssignment = submissionAssignmentRepository.findById(submissionAssignmentId);
        if (submissionAssignment.isEmpty()) {
            log.warn("Could not find submission assignment with id: {}", submissionAssignmentId);
            throw new SubmissionAssignmentNotFoundException("Could not find submission assignment with id: " + submissionAssignmentId);
        }
    }



}