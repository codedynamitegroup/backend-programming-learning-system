package com.backend.programming.learning.system.implement.submission_assignment;

import com.backend.programming.learning.system.dto.method.query.submission_assignment.QueryAllSubmissionnAssignmentCommand;
import com.backend.programming.learning.system.entity.SubmissionAssignment;
import com.backend.programming.learning.system.exception.SubmissionAssignmentNotFoundException;
import com.backend.programming.learning.system.ports.output.repository.SubmissionAssignmentRepository;
import com.backend.programming.learning.system.valueobject.AssignmentId;
import com.backend.programming.learning.system.valueobject.SubmissionAssignmentId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SubmissionAssignmentQueryHelper {
    private final SubmissionAssignmentRepository submissionAssignmentRepository;
    @Transactional(readOnly = true)
    public SubmissionAssignment querySubmissionAssignmentById(UUID submissionAssignmentId) {
        Optional<SubmissionAssignment> submissionAssignment = submissionAssignmentRepository.findById(submissionAssignmentId);
        if (submissionAssignment.isEmpty()) {
            log.error("SubmissionAssignment not found with id: {}", submissionAssignmentId);
            throw new SubmissionAssignmentNotFoundException("SubmissionAssignment not found with id: " + submissionAssignmentId);
        }
        log.info("SubmissionAssignment queried with id: {}", submissionAssignmentId);
        return submissionAssignment.get();
    }

   @Transactional(readOnly=true)
    public List<SubmissionAssignment> queryAllByAssignmentId(QueryAllSubmissionnAssignmentCommand queryAllSubmissionnAssignmentCommand) {
        List<SubmissionAssignment> submissionAssignments = submissionAssignmentRepository.findAllByAssignmentId(new AssignmentId(queryAllSubmissionnAssignmentCommand.getAssignmentId()));
        log.info("SubmissionAssignment queried with assignment id: {}", queryAllSubmissionnAssignmentCommand.getAssignmentId());
        return submissionAssignments;
    }
}
