package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_submission.UpdateCodeSubmissionTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmissionTestCase;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_submission.CodeSubmissionDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CodeSubmissionCommandHandler {
    private final CodeSubmissionDataMapper codeSubmissionDataMapper;
    private final CodeSubmissionHelper codeSubmissionHelper;

    public CodeSubmissionCommandHandler(CodeSubmissionDataMapper codeSubmissionDataMapper, CodeSubmissionHelper codeSubmissionHelper) {
        this.codeSubmissionDataMapper = codeSubmissionDataMapper;
        this.codeSubmissionHelper = codeSubmissionHelper;
    }

    public CreateCodeSubmissionResponse createCodeSubmission(CreateCodeSubmissionCommand createCodeSubmissionCommand) {
        CodeSubmission codeSubmission = codeSubmissionHelper.createCodeSubmission(createCodeSubmissionCommand);
        return codeSubmissionDataMapper.codeSubmissionToCreateCodeSubmissionResponse(codeSubmission);
    }

    public void handleTestCaseResult(UpdateCodeSubmissionTestCaseCommand command) {
        CodeSubmissionTestCase codeSubmissionTestCase = codeSubmissionHelper.handleTestCaseResult(command);

        //single non-query statement to prevent lost update
        codeSubmissionHelper.increaseCodeSubmissionGradedTestCase(codeSubmissionTestCase);
        //log

        //update codeSubmission
        codeSubmissionHelper.updateCodeSubmissionWhenAllTestCaseAssessed(codeSubmissionTestCase.getCodeSubmission().getId());
    }
}
