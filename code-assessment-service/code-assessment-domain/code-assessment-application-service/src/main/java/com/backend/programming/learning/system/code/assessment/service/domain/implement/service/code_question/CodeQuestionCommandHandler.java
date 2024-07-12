package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CodeQuestionAdminDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CodeQuestionDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.DtoMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.langauge.UpdateLanguageOfCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.tag.AddTagToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.code_question.language.DeleteLanguageToCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.code_question.tag.DeleteCodeQuestionTagCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.AdminDetailCodeQuestionQuery;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsQuery;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetDetailCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_question.UpdateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.event.code_question.CodeQuestionsUpdatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.GeneralSagaHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.code_question.CodeQuestionDataMapper;

import com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.code_questions_update_outbox.CodeQuestionsUpdateOutboxHelper;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Component
@Slf4j
public class CodeQuestionCommandHandler {
    private final CodeQuestionsHelper codeQuestionsHelper;
    private final CodeQuestionDataMapper codeQuestionDataMaper;
    private final CodeQuestionsUpdateOutboxHelper codeQuestionsUpdateOutboxHelper;
    private final CodeQuestionsUpdateSagaHelper codeQuestionsUpdateSagaHelper;
    private final DtoMapper dtoMapper;
    private final GeneralSagaHelper generalSagaHelper;

    public CodeQuestionCommandHandler(CodeQuestionsHelper codeQuestionsHelper, CodeQuestionDataMapper codeQuestionDataMaper, CodeQuestionsUpdateOutboxHelper codeQuestionsUpdateOutboxHelper, CodeQuestionsUpdateSagaHelper codeQuestionsUpdateSagaHelper, DtoMapper dtoMapper, GeneralSagaHelper generalSagaHelper) {
        this.codeQuestionsHelper = codeQuestionsHelper;
        this.codeQuestionDataMaper = codeQuestionDataMaper;
        this.codeQuestionsUpdateOutboxHelper = codeQuestionsUpdateOutboxHelper;
        this.codeQuestionsUpdateSagaHelper = codeQuestionsUpdateSagaHelper;
        this.dtoMapper = dtoMapper;
        this.generalSagaHelper = generalSagaHelper;
    }

    @Transactional
    public CreateCodeQuestionResponse createCodeQuestion(CreateCodeQuestionCommand command){
        CodeQuestionsUpdatedEvent codeQuestionsUpdatedEvent = codeQuestionsHelper.persistCodeQuestion(command);

        codeQuestionsUpdateOutboxHelper.saveCodeQuestionsUpdateOutboxMessage(
                codeQuestionDataMaper.codeQuestionsUpdatedEventToCodeQuestionsUpdatePayload(
                        codeQuestionsUpdatedEvent, CopyState.CREATING, command.getCategoryBankId(), command.getEmail()
                ),
                codeQuestionsUpdatedEvent.getCodeQuestion().getCopyState(),
                generalSagaHelper.copyStateToSagaStatus(CopyState.CREATING),
                OutboxStatus.STARTED,
                UUID.randomUUID()
        );
        return codeQuestionDataMaper
                .codeQuestionToCreateCodeQuestionReponse
                        (codeQuestionsUpdatedEvent.getCodeQuestion()
                                , "Code question created successfully");

    }

    public GetCodeQuestionsResponse getPublicCodeQuestions(GetCodeQuestionsQuery query) {
        Page<CodeQuestion> codeQuestions = codeQuestionsHelper.getPublicCodeQuestions(query);
        return codeQuestionDataMaper.pagableCodeQuestionsToGetCodeQuestionsResponse(codeQuestions);
    }

    @Transactional
    public void updateCodeQuestion(UpdateCodeQuestionCommand command) {
        CodeQuestionsUpdatedEvent event = codeQuestionsHelper.updateCodeQuestion(command);
        if(command.getName() != null
                || command.getProblemStatement() != null
                || command.getMaxGrade() != null
                || command.getIsPublic() != null
                || command.getAllowImport() != null
                || command.getIsQuestionBank() != null
                || command.getCategoryBankId() != null){
            codeQuestionsUpdateOutboxHelper.saveCodeQuestionsUpdateOutboxMessage(
                    codeQuestionDataMaper.codeQuestionsUpdatedEventToCodeQuestionsUpdatePayload(
                            event, CopyState.UPDATING, command.getCategoryBankId(), command.getEmail()
                    ),
                    event.getCodeQuestion().getCopyState(),
                    generalSagaHelper.copyStateToSagaStatus(CopyState.UPDATING),
                    OutboxStatus.STARTED,
                    UUID.randomUUID()
            );
        }
    }

    public List<CodeQuestionDto> getDetailCodeQuestion(GetDetailCodeQuestionCommand command) {
        List<CodeQuestion> codeQuestions = codeQuestionsHelper.getDetailCodeQuestion(command);
        return codeQuestions.stream().map(dtoMapper::codeQuestionToDto).toList();
    }

    public void updateLanguageOfCodeQuestion(UpdateLanguageOfCodeQuestionCommand command) {
        codeQuestionsHelper.updateLanguageOfCodeQuestion(command);
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

    public List<CodeQuestionDto> getRecommendedCodeQuestion(String email) {
        return codeQuestionsHelper.getRecommendedCodeQuestion(email)
                .stream()
                .map(dtoMapper::codeQuestionToDtoOnlyNameIdDifficultyAndPeople).toList();
    }

    public GetCodeQuestionsResponse getAdminCodeQuestions(GetCodeQuestionsQuery query) {
        Page<CodeQuestion> codeQuestions = codeQuestionsHelper.getAdminCodeQuestions(query);
        return codeQuestionDataMaper.pagableCodeQuestionsToGetCodeQuestionsResponse(codeQuestions);
    }

    public CodeQuestionAdminDto getAdminDetailCodeQuestion(AdminDetailCodeQuestionQuery query) {
        CodeQuestion codeQuestion = codeQuestionsHelper.getAdminDetailCodeQuestion(query);
        return dtoMapper.codeQuestionToCodeQuestionAdminDto(codeQuestion);
    }

    @Transactional
    public void deleteCodeQuestion(UUID codeQuestionId) {
        CodeQuestionsUpdatedEvent event = codeQuestionsHelper.deleteCodeQuestion(codeQuestionId);

            codeQuestionsUpdateOutboxHelper.saveCodeQuestionsUpdateOutboxMessage(
                    codeQuestionDataMaper.codeQuestionsUpdatedEventToCodeQuestionsUpdatePayload(
                            event, CopyState.DELETING, null, "null"
                    ),
                    event.getCodeQuestion().getCopyState(),
                    generalSagaHelper.copyStateToSagaStatus(CopyState.DELETING),
                    OutboxStatus.STARTED,
                    UUID.randomUUID()
            );

    }
}
