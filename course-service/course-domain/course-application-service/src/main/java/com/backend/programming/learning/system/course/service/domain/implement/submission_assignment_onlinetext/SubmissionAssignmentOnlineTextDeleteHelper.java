package com.backend.programming.learning.system.course.service.domain.implement.submission_assignment_onlinetext;

import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentOnlineText;
import com.backend.programming.learning.system.course.service.domain.exception.SubmissionAssignmentOnlineTextNotFoundException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentOnlineTextRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SubmissionAssignmentOnlineTextDeleteHelper {
    private final SubmissionAssignmentOnlineTextRepository submissionAssignmentOnlineTextRepository;

    @Transactional(readOnly = true)
    public void deleteSubmissionAssignmentOnlineTextById(UUID submissionAssignmentOnlineTextId) {
        checkSubmissionAssignmentOnlineTextExists(submissionAssignmentOnlineTextId);
        submissionAssignmentOnlineTextRepository.
                deleteSubmissionAssignmentOnlineTextById(submissionAssignmentOnlineTextId);
    }

    private void checkSubmissionAssignmentOnlineTextExists(UUID submissionAssignmentOnlineTextId) {
        Optional<SubmissionAssignmentOnlineText> submissionAssignmentOnlineText = submissionAssignmentOnlineTextRepository.findById(submissionAssignmentOnlineTextId);
        if (submissionAssignmentOnlineText.isEmpty()) {
            log.warn("Could not find submission assignment online text with id: {}", submissionAssignmentOnlineTextId);
            throw new SubmissionAssignmentOnlineTextNotFoundException("Could not find submission assignment online text with id: " + submissionAssignmentOnlineTextId);
        }
    }
}
