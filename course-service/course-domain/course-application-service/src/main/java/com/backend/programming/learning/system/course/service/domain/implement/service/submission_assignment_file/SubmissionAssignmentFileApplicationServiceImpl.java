package com.backend.programming.learning.system.course.service.domain.implement.service.submission_assignment_file;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.submission_assignment_file.SubmissionAssignmentFileApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class SubmissionAssignmentFileApplicationServiceImpl implements SubmissionAssignmentFileApplicationService
{
    private final SubmissionAssignmentFileCommandHandler submissionAssignmentFileCommandHandler;
    @Override
    public CreateSubmissionAssignmentFileResponse createSubmissionAssignmentFile(CreateSubmissionAssignmentFileCommand createSubmissionAssignmentFileCommand) {
        return submissionAssignmentFileCommandHandler.createSubmissionAssignmentFile(createSubmissionAssignmentFileCommand);
    }
}
