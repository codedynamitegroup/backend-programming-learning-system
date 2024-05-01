package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.codequestion;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.codequestion.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.codequestion.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionsUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_question.CodeQuestionDataMapper;

import com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.code_questions_update_outbox.CodeQuestionsUpdateOutboxHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Slf4j
public class CodeQuestionCreateCommandHandler {
    private final CodeQuestionsHelper codeQuestionsHelper;
    private final CodeQuestionDataMapper codeQuestionDataMaper;
    private final CodeQuestionsUpdateOutboxHelper codeQuestionsUpdateOutboxHelper;
    private final CodeQuestionsUpdateSagaHelper codeQuestionsUpdateSagaHelper;

    public CodeQuestionCreateCommandHandler(
            CodeQuestionsHelper codeQuestionsHelper,
            CodeQuestionDataMapper codeQuestionDataMaper,
            CodeQuestionsUpdateOutboxHelper codeQuestionsUpdateOutboxHelper,
            CodeQuestionsUpdateSagaHelper codeQuestionsUpdateSagaHelper) {
        this.codeQuestionsHelper = codeQuestionsHelper;
        this.codeQuestionDataMaper = codeQuestionDataMaper;
        this.codeQuestionsUpdateOutboxHelper = codeQuestionsUpdateOutboxHelper;
        this.codeQuestionsUpdateSagaHelper = codeQuestionsUpdateSagaHelper;
    }

    @Transactional
    public CreateCodeQuestionResponse createCodeQuestion(CreateCodeQuestionCommand command){
        CodeQuestionsUpdatedEvent codeQuestionsUpdatedEvent
                = codeQuestionsHelper.persistCodeQuestion(command);
//        codeQuestionsUpdateOutboxHelper.saveCodeQuestionsUpdateOutboxMessage(
//                codeQuestionDataMaper.codeQuestionsUpdatedEventToCodeQuestionsUpdatePayload(
//                        codeQuestionsUpdatedEvent, CopyState.CREATING
//                ),
//                codeQuestionsUpdatedEvent.getCodeQuestion().getCopyState(),
//                codeQuestionsUpdateSagaHelper.copyStateToSagaStatus(CopyState.CREATING),
//                OutboxStatus.STARTED,
//                UUID.randomUUID()
//        );
        return codeQuestionDataMaper
                .codeQuestionToCreateCodeQuestionReponse
                        (codeQuestionsUpdatedEvent.getCodeQuestion()
                                , "Code question created successfully");

    }

}
