package com.backend.programming.learning.system.course.service.domain.implement.service.submission_assignment_file;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;
import com.backend.programming.learning.system.course.service.domain.exception.SubmissionAssignmentNotFoundException;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment_file.SubmissionAssignmentFileDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentFileRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SubmissionAssignmentFileCreateHelper {
    private final CourseDomainService coureDomainService;
    private final SubmissionAssignmentRepository submissionAssignmentRepository;
    private final SubmissionAssignmentFileRepository submissionAssignmentFileRepository;
    private final SubmissionAssignmentFileDataMapper submissionAssignmentFileDataMapper;

    public SubmissionAssignmentFile persistSubmissionAssignmentFile(CreateSubmissionAssignmentFileCommand createSubmissionAssignmentFileCommand) {
        SubmissionAssignmentFile submissionAssignmentFile = submissionAssignmentFileDataMapper
                .createSubmissionAssignmentFileCommandToSubmissionAssignmentFile(createSubmissionAssignmentFileCommand);
        coureDomainService.createSubmissionAssignmentFile(submissionAssignmentFile);
        SubmissionAssignmentFile submissionAssignmentFileResult = saveSubmissionAssignmentFile(submissionAssignmentFile);
        return submissionAssignmentFileResult;
    }

    private SubmissionAssignmentFile saveSubmissionAssignmentFile(SubmissionAssignmentFile submissionAssignmentFile) {
        SubmissionAssignmentFile savedSubmissionAssignmentFile =
                submissionAssignmentFileRepository.saveSubmissionAssignmentFile(submissionAssignmentFile);
        if(savedSubmissionAssignmentFile == null) {
            log.error("AssignmentSubmissionFile is not saved");
            throw new RuntimeException("AssignmentSubmissionFile is not saved");
        }
        log.info("AssignmentSubmissionFile is saved");
        return savedSubmissionAssignmentFile;
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
