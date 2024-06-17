package com.backend.programming.learning.system.course.service.domain.implement.service.submission_assignment_file;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_file.DeleteSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_file.DeleteSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment_file.UpdateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment_file.UpdateSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.submission_assignment_file.SubmissionAssignmentFileApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

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

    @Override
    public UpdateSubmissionAssignmentFileResponse updateSubmissionAssignmentFile(UpdateSubmissionAssignmentFileCommand updateSubmissionAssignmentFileCommand, UUID id) {
        return submissionAssignmentFileCommandHandler.updateSubmissionAssignmentFile(updateSubmissionAssignmentFileCommand, id);
    }

    @Override
    public DeleteSubmissionAssignmentFileResponse deleteSubmissionAssignmentFile(DeleteSubmissionAssignmentFileCommand deleteSubmissionAssignmentFileCommand) {
        return submissionAssignmentFileCommandHandler.deleteSubmissionAssignmentFile(deleteSubmissionAssignmentFileCommand.getId());
    }
}
