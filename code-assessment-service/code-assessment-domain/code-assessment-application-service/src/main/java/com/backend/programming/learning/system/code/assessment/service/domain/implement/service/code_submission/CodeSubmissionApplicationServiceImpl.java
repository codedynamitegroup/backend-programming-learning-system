package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.ExecuteCodeWithTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.*;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_submission.UpdateCodeSubmissionTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeSubmissionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Slf4j
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
    public GetCodeSubmissionReponse getCodeSubmissionsByUserId(GetCodeSubmissionsByUserIdCommand command) {

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

    @Override
    public String executeCodeWithTestCase(ExecuteCodeWithTestCaseCommand command) {
        return codeSubmissionCommandHandler.executeCodeWithTestCase(command);
    }

    @Override
    public GetCodeSubmissionReponse getAdminCodeSubmissions(AdminCodeSubmissionQuery command) {
        return codeSubmissionCommandHandler.getAdminCodeSubmissions(command);
    }

    @Override
    public GetCodeSubmissionReponse getUserRecentCodeSubmissions(UserCodeSubmissionQuery query) {
        return codeSubmissionCommandHandler.getUserRecentCodeSubmissions(query);
    }

    @Override
    public GetCodeQuestionsResponse getUserRecentCodeQuestion(UserRecentCodeQuestionQuery query) {
        return codeSubmissionCommandHandler.getUserRecentCodeQuestion(query);
    }

    @Override
    public List<SubmissionHeadMapItem> getHeatMap(String email, Integer year) {
        List<SubmissionHeadMapItem> cc = codeSubmissionCommandHandler.getHeatMap(email, year);
        return cc;
    }
}
