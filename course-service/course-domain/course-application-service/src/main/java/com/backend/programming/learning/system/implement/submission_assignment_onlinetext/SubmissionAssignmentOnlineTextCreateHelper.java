package com.backend.programming.learning.system.implement.submission_assignment_onlinetext;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.dto.method.create.submission_assignment_onlinetext.CreateSubmissionAssignmentOnlineTextCommand;
import com.backend.programming.learning.system.entity.SubmissionAssignment;
import com.backend.programming.learning.system.entity.SubmissionAssignmentOnlineText;
import com.backend.programming.learning.system.exception.SubmissionAssignmentNotFoundException;
import com.backend.programming.learning.system.mapper.submission_assignment.SubmissionAssignmentDataMapper;
import com.backend.programming.learning.system.mapper.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextDataMapper;
import com.backend.programming.learning.system.ports.output.repository.AssignmentRepository;
import com.backend.programming.learning.system.ports.output.repository.SubmissionAssignmentOnlineTextRepository;
import com.backend.programming.learning.system.ports.output.repository.SubmissionAssignmentRepository;
import com.backend.programming.learning.system.ports.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SubmissionAssignmentOnlineTextCreateHelper {
    private final CourseDomainService coureDomainService;
    private final SubmissionAssignmentRepository submissionAssignmentRepository;
    private final SubmissionAssignmentOnlineTextRepository submissionAssignmentOnlineTextRepository;
    private final SubmissionAssignmentOnlineTextDataMapper submissionAssignmentOnlineTextDataMapper;

    @Transactional
    public SubmissionAssignmentOnlineText persistSubmissionAssignmentOnlineText(CreateSubmissionAssignmentOnlineTextCommand createSubmissionAssignmentOnlineTextCommand) {
        SubmissionAssignment submissionAssignment = getSubmissionAssignment(createSubmissionAssignmentOnlineTextCommand.getSubmissionAssignmentId());
        SubmissionAssignmentOnlineText submissionAssignmentOnlineText = submissionAssignmentOnlineTextDataMapper
                .createSubmissionAssignmentOnlineTextCommandToSubmissionAssignmentOnlineText(createSubmissionAssignmentOnlineTextCommand);
        coureDomainService.createSubmissionAssignmentOnlineText(submissionAssignmentOnlineText);
        submissionAssignmentOnlineText.setSubmissionAssignment(submissionAssignment);
        SubmissionAssignmentOnlineText submissionAssignmentOnlineTextResult = saveSubmissionAssignmentOnlineText(submissionAssignmentOnlineText);
        return submissionAssignmentOnlineTextResult;
    }

    private SubmissionAssignmentOnlineText saveSubmissionAssignmentOnlineText(SubmissionAssignmentOnlineText submissionAssignmentOnlineText) {
        SubmissionAssignmentOnlineText savedSubmissionAssignmentOnlineText =
                submissionAssignmentOnlineTextRepository.saveAssignmentSubmissionOnlineText(submissionAssignmentOnlineText);
        if(savedSubmissionAssignmentOnlineText == null) {
            log.error("AssignmentSubmissionOnlineText is not saved");
            throw new RuntimeException("AssignmentSubmissionOnlineText is not saved");
        }
        log.info("AssignmentSubmissionOnlineText is saved");
        return savedSubmissionAssignmentOnlineText;
    }

    private SubmissionAssignment getSubmissionAssignment(UUID submissionAssignmentId) {
        Optional<SubmissionAssignment> submissionAssignment = submissionAssignmentRepository.findById(submissionAssignmentId);
        if (submissionAssignment.isEmpty()) {
            log.warn("SubmissionAssignment with id: {} not found", submissionAssignmentId);
            throw new SubmissionAssignmentNotFoundException("Could not find submissionAssignment with id: " + submissionAssignmentId);
        }
        return submissionAssignment.get();
    }
}
