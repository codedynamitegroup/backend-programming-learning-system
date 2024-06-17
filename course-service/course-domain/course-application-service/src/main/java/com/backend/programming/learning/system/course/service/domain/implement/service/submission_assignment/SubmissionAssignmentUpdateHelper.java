package com.backend.programming.learning.system.course.service.domain.implement.service.submission_assignment;

import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment.UpdateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.exception.SubmissionAssignmentNotFoundException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SubmissionAssignmentUpdateHelper {
    private final SubmissionAssignmentRepository submissionAssignmentRepository;

    @Transactional
    public void persistSubmissionAssignment(UpdateSubmissionAssignmentCommand updateSubmissionAssignmentCommand,UUID id) {
        SubmissionAssignment submissionAssignment = getSubmissionAssignment(id);
        if (updateSubmissionAssignmentCommand.getIsGraded() != null) {
            submissionAssignment.setIsGraded(updateSubmissionAssignmentCommand.getIsGraded());
        }

        if (updateSubmissionAssignmentCommand.getGrade() != null) {
            submissionAssignment.setGrade(updateSubmissionAssignmentCommand.getGrade());
        }

        if (updateSubmissionAssignmentCommand.getContent() != null) {
            submissionAssignment.setContent(updateSubmissionAssignmentCommand.getContent());
        }

        if (updateSubmissionAssignmentCommand.getTimeSubmit() != null) {
            submissionAssignment.setSubmittedAt(updateSubmissionAssignmentCommand.getTimeSubmit());
        }

        submissionAssignmentRepository.saveSubmissionAssignment(submissionAssignment);
    }

    private SubmissionAssignment getSubmissionAssignment(UUID submissionAssignmentId) {
        Optional<SubmissionAssignment> submissionAssignment = submissionAssignmentRepository.findById(submissionAssignmentId);
        if (submissionAssignment.isEmpty()) {
            log.error("SubmissionAssignment not found with id: {}", submissionAssignmentId);
            throw new SubmissionAssignmentNotFoundException("SubmissionAssignment not found with id: " + submissionAssignmentId);
        }
        return submissionAssignment.get();
    }
}
