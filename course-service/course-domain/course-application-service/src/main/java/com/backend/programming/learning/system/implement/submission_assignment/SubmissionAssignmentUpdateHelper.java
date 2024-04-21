package com.backend.programming.learning.system.implement.submission_assignment;

import com.backend.programming.learning.system.dto.update.submission_assignment.UpdateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.entity.SubmissionAssignment;
import com.backend.programming.learning.system.exception.SubmissionAssignmentNotFoundException;
import com.backend.programming.learning.system.ports.output.repository.SubmissionAssignmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SubmissionAssignmentUpdateHelper {
    private final SubmissionAssignmentRepository submissionAssignmentRepository;

    @Transactional(readOnly = true)
    public void persistSubmissionAssignment(UpdateSubmissionAssignmentCommand updateSubmissionAssignmentCommand) {
        SubmissionAssignment submissionAssignment = getSubmissionAssignment(updateSubmissionAssignmentCommand.getSubmissionAssignmentId());
        if (updateSubmissionAssignmentCommand.getPass_status() != null) {
            submissionAssignment.setPass_status(updateSubmissionAssignmentCommand.getPass_status());
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
