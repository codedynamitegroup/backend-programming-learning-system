package com.backend.programming.learning.system.course.service.domain.implement.service.submission_assignment_file;

import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;
import com.backend.programming.learning.system.course.service.domain.exception.SubmissionAssignmentNotFoundException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentFileRepository;
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
public class SubmissionAssignmentFileDeleteHelper {
    private final SubmissionAssignmentFileRepository submissionAssignmentFileRepository;

    @Transactional
    public void deleteSubmissionAssignmentFileById(UUID submissionAssignmentFileId) {
        checkSubmissionAssignmentFileExists(submissionAssignmentFileId);
        submissionAssignmentFileRepository.deleteById(submissionAssignmentFileId);
    }

    private void checkSubmissionAssignmentFileExists(UUID submissionAssignmentFileId) {
        Optional<SubmissionAssignmentFile> submissionAssignmentFile = submissionAssignmentFileRepository.findById(submissionAssignmentFileId);
        if (submissionAssignmentFile.isEmpty()) {
            log.warn("Could not find submission assignment file with id: {}", submissionAssignmentFileId);
            throw new SubmissionAssignmentNotFoundException("Could not find submission assignment file with id: " + submissionAssignmentFileId);
        }
    }
}
