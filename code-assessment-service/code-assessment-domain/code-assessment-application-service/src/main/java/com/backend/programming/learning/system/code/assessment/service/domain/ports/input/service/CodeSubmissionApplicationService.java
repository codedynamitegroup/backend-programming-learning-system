package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionResponse;

import javax.validation.Valid;

public interface CodeSubmissionApplicationService {
    CreateCodeSubmissionResponse createCodeSubmission(@Valid CreateCodeSubmissionCommand createCodeSubmissionCommand);
}
