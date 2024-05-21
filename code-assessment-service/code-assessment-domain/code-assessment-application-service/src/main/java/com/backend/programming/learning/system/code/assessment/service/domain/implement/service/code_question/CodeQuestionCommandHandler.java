package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CodeQuestionDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.DtoMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.langauge.AddLanguageToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.tag.AddTagToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.code_question.language.DeleteLanguageToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.code_question.tag.DeleteCodeQuestionTagCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsQuery;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetDetailCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_question.UpdateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionsUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_question.CodeQuestionDataMapper;

import com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.code_questions_update_outbox.CodeQuestionsUpdateOutboxHelper;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Component
@Slf4j
public class CodeQuestionCommandHandler {
    private final CodeQuestionsHelper codeQuestionsHelper;
    private final CodeQuestionDataMapper codeQuestionDataMaper;
    private final CodeQuestionsUpdateOutboxHelper codeQuestionsUpdateOutboxHelper;
    private final CodeQuestionsUpdateSagaHelper codeQuestionsUpdateSagaHelper;
    private final DtoMapper dtoMapper;

    public CodeQuestionCommandHandler(CodeQuestionsHelper codeQuestionsHelper, CodeQuestionDataMapper codeQuestionDataMaper, CodeQuestionsUpdateOutboxHelper codeQuestionsUpdateOutboxHelper, CodeQuestionsUpdateSagaHelper codeQuestionsUpdateSagaHelper, DtoMapper dtoMapper) {
        this.codeQuestionsHelper = codeQuestionsHelper;
        this.codeQuestionDataMaper = codeQuestionDataMaper;
        this.codeQuestionsUpdateOutboxHelper = codeQuestionsUpdateOutboxHelper;
        this.codeQuestionsUpdateSagaHelper = codeQuestionsUpdateSagaHelper;
        this.dtoMapper = dtoMapper;
    }

    @Transactional
    public CreateCodeQuestionResponse createCodeQuestion(CreateCodeQuestionCommand command){
        CodeQuestionsUpdatedEvent codeQuestionsUpdatedEvent
                = codeQuestionsHelper.persistCodeQuestion(command);
        codeQuestionsUpdateOutboxHelper.saveCodeQuestionsUpdateOutboxMessage(
                codeQuestionDataMaper.codeQuestionsUpdatedEventToCodeQuestionsUpdatePayload(
                        codeQuestionsUpdatedEvent, CopyState.CREATING
                ),
                codeQuestionsUpdatedEvent.getCodeQuestion().getCopyState(),
                codeQuestionsUpdateSagaHelper.copyStateToSagaStatus(CopyState.CREATING),
                OutboxStatus.STARTED,
                UUID.randomUUID()
        );
        return codeQuestionDataMaper
                .codeQuestionToCreateCodeQuestionReponse
                        (codeQuestionsUpdatedEvent.getCodeQuestion()
                                , "Code question created successfully");

    }

    public GetCodeQuestionsResponse getCodeQuestions(GetCodeQuestionsQuery query) {
        Page<CodeQuestion> codeQuestions = codeQuestionsHelper.getCodeQuestions(query);
        return codeQuestionDataMaper.pagableCodeQuestionsToGetCodeQuestionsResponse(codeQuestions);
    }

    public void updateCodeQuestion(UpdateCodeQuestionCommand command) {
        codeQuestionsHelper.updateCodeQuestion(command);
    }

    public CodeQuestionDto getDetailCodeQuestion(GetDetailCodeQuestionCommand command) {
        CodeQuestion codeQuestion = codeQuestionsHelper.getDetailCodeQuestion(command);
        return dtoMapper.codeQuestionToDto(codeQuestion);
    }

    public void addLanguageToCodeQuestion(AddLanguageToCodeQuestionCommand command) {
        codeQuestionsHelper.addLanguageToCodeQuestion(command);
    }

    public void deleteProgrammingLanguageCodeQuestion(DeleteLanguageToCodeQuestionCommand command) {
        codeQuestionsHelper.deleteProgrammingLanguageCodeQuestion(command);
    }

    public void addTagToCodeQuestion(AddTagToCodeQuestionCommand command) {
        codeQuestionsHelper.addTagToCodeQuestion(command);
    }

    public void deleteCodeQuestionTag(DeleteCodeQuestionTagCommand command) {
        codeQuestionsHelper.deleteCodeQuestionTag(command);
    }
}
