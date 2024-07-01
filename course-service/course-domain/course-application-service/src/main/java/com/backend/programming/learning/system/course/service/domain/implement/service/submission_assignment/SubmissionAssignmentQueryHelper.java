package com.backend.programming.learning.system.course.service.domain.implement.service.submission_assignment;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.QueryAllSubmissionnAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.exception.SubmissionAssignmentNotFoundException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.AssignmentId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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
    public Page<SubmissionAssignment> queryAllByAssignmentId(QueryAllSubmissionnAssignmentCommand queryAllSubmissionnAssignmentCommand) {
        Page<SubmissionAssignment> submissionAssignments = submissionAssignmentRepository.findAllByAssignmentId(queryAllSubmissionnAssignmentCommand.getAssignmentId(),
                queryAllSubmissionnAssignmentCommand.getSearchName(),
                queryAllSubmissionnAssignmentCommand.getIsGraded(),
                queryAllSubmissionnAssignmentCommand.getPageNo(),
                queryAllSubmissionnAssignmentCommand.getPageSize());
        log.info("SubmissionAssignment queried with assignment id: {}", queryAllSubmissionnAssignmentCommand.getAssignmentId());
        return submissionAssignments;
    }

    @Transactional(readOnly=true)
    public SubmissionAssignment queryByAssignmentIdAndUserId(UUID assignmentId,UUID userId) {
       SubmissionAssignment submissionAssignment = submissionAssignmentRepository.findByAssignmentIdAndUserId(assignmentId, userId);
        log.info("SubmissionAssignment queried with assignment id: {} and user id: {}", assignmentId, userId);
        return submissionAssignment;
    }
    @Transactional(readOnly=true)
    public Integer countSubmissionsToGrade(UUID assignmentId) {
        Integer count = submissionAssignmentRepository.countSubmissionsToGradeByAssignmentId(assignmentId);
        log.info("SubmissionAssignment count with assignment id: {} and graded: {}", assignmentId);
        return count;
    }
    @Transactional(readOnly=true)
    public Integer countAllByAssignmentId(UUID assignmentId) {
        return submissionAssignmentRepository.countAllByAssignmentId(assignmentId);
    }
}
