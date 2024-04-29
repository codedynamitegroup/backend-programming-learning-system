package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeSubmissionApplicationService;
import org.springframework.stereotype.Component;

@Component
public class CodeSubmissionApplicationServiceImpl implements CodeSubmissionApplicationService {
    private final CodeSubmissionCommandHandler codeSubmissionCommandHandler;

    public CodeSubmissionApplicationServiceImpl(CodeSubmissionCommandHandler codeSubmissionCommandHandler) {
        this.codeSubmissionCommandHandler = codeSubmissionCommandHandler;
    }

    @Override
    public CreateCodeSubmissionResponse createCodeSubmission(CreateCodeSubmissionCommand createCodeSubmissionCommand) {
        return codeSubmissionCommandHandler.createCodeSubmission(createCodeSubmissionCommand);

    }
}
