package com.backend.programming.learning.system.course.service.domain.ports.input.service.submission_assignment_file;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileResponse;

import javax.validation.Valid;

public interface SubmissionAssignmentFileApplicationService {

    CreateSubmissionAssignmentFileResponse createSubmissionAssignmentFile(@Valid CreateSubmissionAssignmentFileCommand createSubmissionAssignmentFileCommand);

}
