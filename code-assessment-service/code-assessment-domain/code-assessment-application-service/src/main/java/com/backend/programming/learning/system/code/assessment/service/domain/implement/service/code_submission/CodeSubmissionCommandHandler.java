package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.*;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_submission.UpdateCodeSubmissionTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmissionTestCase;
import com.backend.programming.learning.system.code.assessment.service.domain.event.code_submission.CodeSubmissionUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.GeneralSagaHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_submission.CodeSubmissionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.code_submission_update_outbox.CodeSubmissionUpdateOutboxHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.assessment.AssessmentSourceCodeByTestCases;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CodeSubmissionCommandHandler {
    private final CodeSubmissionDataMapper codeSubmissionDataMapper;
    private final AssessmentSourceCodeByTestCases assessmentSourceCodeByTestCases;
    private final CodeSubmissionHelper codeSubmissionHelper;
    private final CodeSubmissionUpdateOutboxHelper codeSubmissionUpdateOutboxHelper;
    private final GeneralSagaHelper generalSagaHelper;

    public CodeSubmissionCommandHandler(CodeSubmissionDataMapper codeSubmissionDataMapper, AssessmentSourceCodeByTestCases assessmentSourceCodeByTestCases, CodeSubmissionHelper codeSubmissionHelper, CodeSubmissionUpdateOutboxHelper codeSubmissionUpdateOutboxHelper, GeneralSagaHelper generalSagaHelper) {
        this.codeSubmissionDataMapper = codeSubmissionDataMapper;
        this.assessmentSourceCodeByTestCases = assessmentSourceCodeByTestCases;
        this.codeSubmissionHelper = codeSubmissionHelper;
        this.codeSubmissionUpdateOutboxHelper = codeSubmissionUpdateOutboxHelper;
        this.generalSagaHelper = generalSagaHelper;
    }

    public CreateCodeSubmissionResponse createCodeSubmission(CreateCodeSubmissionCommand createCodeSubmissionCommand) {
        CodeSubmissionUpdatedEvent event = codeSubmissionHelper.createCodeSubmission(createCodeSubmissionCommand);
        CodeSubmission codeSubmission = event.getCodeSubmission();

        //send jugde0 and cron to check all graded
        assessmentSourceCodeByTestCases.judge(codeSubmission);
        Thread thread2 = new Thread(()->{
            boolean finish = false;
            do{
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                finish = codeSubmissionHelper.updateCodeSubmissionWhenAllTestCaseAssessed(codeSubmission.getId());
            }while(!finish);
        });
        thread2.start();

        codeSubmissionUpdateOutboxHelper.saveCodeSubmissionUpdateOutboxMessage(
                codeSubmissionDataMapper.codeSubmissionUpdatedEventToCodeSubmissionUpdatePayload(
                        event, CopyState.CREATING
                ),
                event.getCodeSubmission().getCopyState(),
                generalSagaHelper.copyStateToSagaStatus(CopyState.CREATING),
                OutboxStatus.STARTED,
                UUID.randomUUID()
        );

        return codeSubmissionDataMapper.codeSubmissionToCreateCodeSubmissionResponse(codeSubmission);
    }

    public void handleTestCaseResult(UpdateCodeSubmissionTestCaseCommand command) {
        CodeSubmissionTestCase codeSubmissionTestCase = codeSubmissionHelper.handleTestCaseResult(command);

        //single non-query statement to prevent lost update
        codeSubmissionHelper.increaseCodeSubmissionGradedTestCase(codeSubmissionTestCase);
        //log

        //update codeSubmission

    }

    public GetCodeSubmissionReponse getCodeSubmissionsByUserId(GetCodeSubmissionsByUserIdCommand command) {
        Page<CodeSubmission> codeSubmissions = codeSubmissionHelper.getCodeSubmissionsByUserId(command);

        Page<GetCodeSubmissionResponseItem> list = codeSubmissions.map(
                        codeSubmissionDataMapper::codeSubmissionToGetCodeSubmissionResponseItem);
        list.forEach(item -> {
            item.setHeadCode(null);
            item.setBodyCode(null);
            item.setTailCode(null);
        });
        return codeSubmissionDataMapper.pagableToGetCodeSubmissionReponse(list);
    }

    public GetCodeSubmissionResponseItem getCodeSubmissionsById(GetDetailCodeSubmissionsByIdCommand command) {
        CodeSubmission codeSubmission = codeSubmissionHelper.getCodeSubmissionsById(command);
        GetCodeSubmissionResponseItem item = codeSubmissionDataMapper.codeSubmissionToGetCodeSubmissionResponseItem(codeSubmission);
        CodeSubmissionTestCase cstc = codeSubmissionHelper.findFirstNonAcceptedTestCase(new CodeSubmissionId(command.getCodeSubmissionId()));
        item.setFirstFailTestCase(codeSubmissionDataMapper.codeSubmissionTestCaseToFirstFailTestCase(cstc));
        return item;
    }

    public GetMemoryAndTimeRankingResponse getMemoryAndRunTimeRanking(GetMemoryAndTimeRankingCommand command) {
        return codeSubmissionHelper.getMemoryAndRunTimeRanking(command);
    }
}
