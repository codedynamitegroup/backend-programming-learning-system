package com.backend.programming.learning.system.course.service.domain.ports.input.service.submission_assignment_file;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileResponse;

import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_file.DeleteSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_file.DeleteSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment_file.UpdateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment_file.UpdateSubmissionAssignmentFileResponse;
import jakarta.validation.Valid;

import java.util.UUID;

public interface SubmissionAssignmentFileApplicationService {

    CreateSubmissionAssignmentFileResponse createSubmissionAssignmentFile(@Valid CreateSubmissionAssignmentFileCommand createSubmissionAssignmentFileCommand);

    UpdateSubmissionAssignmentFileResponse updateSubmissionAssignmentFile(@Valid UpdateSubmissionAssignmentFileCommand updateSubmissionAssignmentFileCommand, UUID id);

    DeleteSubmissionAssignmentFileResponse deleteSubmissionAssignmentFile(@Valid DeleteSubmissionAssignmentFileCommand deleteSubmissionAssignmentFileCommand);
}
