package com.backend.programming.learning.system.course.service.domain.implement.submission_assignment_file;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment_file.SubmissionAssignmentFileDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentFileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@RequiredArgsConstructor
public class SubmissionAssignmentFileCommandHandler {
    private final SubmissionAssignmentFileRepository submissionAssignmentFileRepository;
    private final SubmissionAssignmentFileCreateHelper submissionAssignmentFileCreateHelper;
    private final SubmissionAssignmentFileDataMapper submissionAssignmentFileDataMapper;

    @Transactional
    public CreateSubmissionAssignmentFileResponse createSubmissionAssignmentFile(CreateSubmissionAssignmentFileCommand createSubmissionAssignmentFileCommand) {
        SubmissionAssignmentFile submissionAssignmentFile = submissionAssignmentFileCreateHelper
                .persistSubmissionAssignmentFile(createSubmissionAssignmentFileCommand);
        return submissionAssignmentFileDataMapper
                .submissionAssignmentFileToCreateSubmissionAssignmentFileResponse(submissionAssignmentFile,
                        "SubmissionAssignmentFile created successfully");

    }
}
