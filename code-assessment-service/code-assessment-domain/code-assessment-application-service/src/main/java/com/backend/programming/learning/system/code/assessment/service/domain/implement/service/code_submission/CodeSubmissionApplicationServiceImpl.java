package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.*;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_submission.UpdateCodeSubmissionTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeSubmissionApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class CodeSubmissionApplicationServiceImpl implements CodeSubmissionApplicationService {
    private final CodeSubmissionCommandHandler codeSubmissionCommandHandler;

    public CodeSubmissionApplicationServiceImpl(CodeSubmissionCommandHandler codeSubmissionCommandHandler) {
        this.codeSubmissionCommandHandler = codeSubmissionCommandHandler;
    }

    @Override
    public CreateCodeSubmissionResponse createCodeSubmission(CreateCodeSubmissionCommand createCodeSubmissionCommand) {
        return codeSubmissionCommandHandler.createCodeSubmission(createCodeSubmissionCommand);

    }

    @Override
    public void handleTestCaseResult(UpdateCodeSubmissionTestCaseCommand command) {
        codeSubmissionCommandHandler.handleTestCaseResult(command);
    }

    @Override
    public List<GetCodeSubmissionResponseItem> getCodeSubmissionsByUserId(GetCodeSubmissionsByUserIdCommand command) {

        return codeSubmissionCommandHandler.getCodeSubmissionsByUserId(command);
    }

    @Override
    public GetCodeSubmissionResponseItem getCodeSubmissionsById(GetDetailCodeSubmissionsByIdCommand command) {
        return codeSubmissionCommandHandler.getCodeSubmissionsById(command);

    }

    @Override
    public GetMemoryAndTimeRankingResponse getMemoryAndRunTimeRanking(GetMemoryAndTimeRankingCommand command) {
        return codeSubmissionCommandHandler.getMemoryAndRunTimeRanking(command);
    }
}
