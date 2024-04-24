package com.backend.programming.learning.system.implement.submission_assignment_onlinetext;

import com.backend.programming.learning.system.entity.SubmissionAssignmentOnlineText;
import com.backend.programming.learning.system.exception.SubmissionAssignmentOnlineTextNotFoundException;
import com.backend.programming.learning.system.ports.output.repository.SubmissionAssignmentOnlineTextRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SubmissionAssignmentOnlineTextQueryHelper {
    private final SubmissionAssignmentOnlineTextRepository submissionAssignmentOnlineTextRepository;

    @Transactional(readOnly = true)
    public SubmissionAssignmentOnlineText querySubmissionAssignmentOnlineTextById(UUID submissionAssignmentOnlineTextId) {
        Optional<SubmissionAssignmentOnlineText> submissionAssignmentOnlineText = submissionAssignmentOnlineTextRepository.
                findById(submissionAssignmentOnlineTextId);
        if (submissionAssignmentOnlineText.isEmpty()) {
            log.error("SubmissionAssignmentOnlineText not found with id: {}", submissionAssignmentOnlineTextId);
            throw new SubmissionAssignmentOnlineTextNotFoundException("SubmissionAssignmentOnlineText not found with id: " + submissionAssignmentOnlineTextId);
        }
        log.info("SubmissionAssignmentOnlineText queried with id: {}", submissionAssignmentOnlineTextId);
        return submissionAssignmentOnlineText.get();
    }
}
