package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionCloneResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.AnswerOfQuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAllQuestionWithPaginationResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAnswerOfQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.AnswerOfQuestionUpdateEntity;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionEntity;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.AnswerOfQuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.GetAllQuestionPaginationResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionDeletedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.mapper.organization.OrganizationDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionDeleteEventPayload;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.AnswerId;
import com.backend.programming.learning.system.domain.valueobject.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
public class QuestionDataMapper {
    private final OrganizationDataMapper organizationDataMapper;
    private final UserDataMapper userDataMapper;

    public QuestionDataMapper(OrganizationDataMapper organizationDataMapper, UserDataMapper userDataMapper) {
        this.organizationDataMapper = organizationDataMapper;
        this.userDataMapper = userDataMapper;
    }

    // create question command to question
    public Question createQuestionCommandToQuestion(CreateQuestionCommand createQuestionCommand,
                                                    Organization organization,
                                                    User createdBy,
                                                    User updatedBy) {
        Boolean isOrgQuestionBank = Objects.requireNonNullElse(createQuestionCommand.getIsOrgQuestionBank(), false);
        return Question.builder()
                .organization(organization)
                .name(createQuestionCommand.getName())
                .questionText(createQuestionCommand.getQuestionText())
                .generalFeedback(createQuestionCommand.getGeneralFeedback())
                .defaultMark(createQuestionCommand.getDefaultMark().floatValue())
                .difficulty(QuestionDifficulty.valueOf(createQuestionCommand.getDifficulty()))
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .qtype(QuestionType.valueOf(createQuestionCommand.getQType()))
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .questionBankCategoryId(createQuestionCommand.getQuestionBankCategoryId())
                .isOrgQuestionBank(isOrgQuestionBank)
                .build();
    }

    public Question setQuestionWithAnswers(Question question, List<AnswerOfQuestion> answers) {
        return Question.builder()
                .questionId(question.getId())
                .organization(question.getOrganization())
                .name(question.getName())
                .questionText(question.getQuestionText())
                .generalFeedback(question.getGeneralFeedback())
                .defaultMark(question.getDefaultMark())
                .difficulty(question.getDifficulty())
                .createdBy(question.getCreatedBy())
                .updatedBy(question.getUpdatedBy())
                .qtype(question.getqtype())
                .createdAt(question.getCreatedAt())
                .updatedAt(question.getUpdatedAt())
                .answers(answers)
                .build();
    }

    public List<AnswerOfQuestion> answerOfQuestionListToAnswerOfQuestionEntityList(List<com.backend.programming.learning.system.core.service.domain.dto.method.create.question.AnswerOfQuestion> answerOfQuestions
            , QuestionId questionId) {
        if (answerOfQuestions == null) return null;

        return List.of(answerOfQuestions.stream()
                .map(answerOfQuestion -> AnswerOfQuestion.builder()
                        .questionId(questionId)
                        .answer(answerOfQuestion.getAnswer())
                        .fraction(answerOfQuestion.getFraction())
                        .feedback(answerOfQuestion.getFeedback())
                        .build())
                .toArray(AnswerOfQuestion[]::new));
    }

    // question to create question response
    public CreateQuestionResponse questionCreatedEventToCreateQuestionResponse(QuestionCreatedEvent questionCreatedEvent, String message) {
        return CreateQuestionResponse.builder()
                .questionId(questionCreatedEvent.getQuestion().getId().getValue())
//                .qtypeId(questionCreatedEvent.getQtypeID())
                .message(message)
                .build();
    }

    // question to query question response
    public QuestionResponseEntity questionToQuestionResponseEntity(Question question) {
        return QuestionResponseEntity.builder()
                .id(question.getId().getValue().toString())
                .organization(
                        question.getOrganization() != null
                                ? organizationDataMapper.organizationToOrganizationResponseEntity(question.getOrganization())
                                : null)
                .name(question.getName())
                .questionText(question.getQuestionText())
                .generalFeedback(question.getGeneralFeedback())
                .defaultMark(question.getDefaultMark())
                .pass(question.getPass())
                .difficulty(question.getDifficulty())
                .createdBy(userDataMapper.userToUserResponseEntity(question.getCreatedBy()))
                .updatedBy(userDataMapper.userToUserResponseEntity(question.getUpdatedBy()))
                .qtype(question.getqtype())
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .answers(answerOfQuestionListToAnswerOfQuestionResponseEntityList(question.getAnswers()))
                .build();
    }

    public QuestionResponseEntity questionTrueFalseToQuestionTrueFalseResponseEntity(Question question) {
        return QuestionResponseEntity.builder()
                .id(question.getId().getValue().toString())
                .organization(organizationDataMapper.organizationToOrganizationResponseEntity(question.getOrganization()))
                .name(question.getName())
                .questionText(question.getQuestionText())
                .generalFeedback(question.getGeneralFeedback())
                .defaultMark(question.getDefaultMark())
                .pass(question.getPass())
                .difficulty(question.getDifficulty())
                .createdBy(userDataMapper.userToUserResponseEntity(question.getCreatedBy()))
                .updatedBy(userDataMapper.userToUserResponseEntity(question.getUpdatedBy()))
                .qtype(QuestionType.TRUE_FALSE)
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .answers(answerOfQuestionListToAnswerOfQuestionResponseEntityList(question.getAnswers()))
                .build();
    }

    public AnswerOfQuestionDeleteResponse answerOfQuestionToAnswerOfQuestionDeleteResponse(UUID answerId) {
        return AnswerOfQuestionDeleteResponse.builder()
                .answerId(answerId)
                .message("Answer deleted successfully")
                .build();
    }

    public Question updateQuestionEntityToQuestion(UpdateQuestionEntity updateQuestionEntity,
                                                   Question prevQuestion,
                                                   QuestionId questionId,
                                                   Organization organization,
                                                   User createdBy,
                                                   QuestionType qtype,
                                                   List<AnswerOfQuestion> answers) {
        if (updateQuestionEntity == null) return null;

        if (updateQuestionEntity.getAnswers() != null) {
            answers = updateQuestionEntity.getAnswers()
                    .stream()
                    .map(answer -> answerOfQuestionUpdateEntityToAnswerOfQuestion(answer, questionId))
                    .toList();
        }

        String name = updateQuestionEntity.getName();
        String questionText = updateQuestionEntity.getQuestionText();
        String generalFeedback = updateQuestionEntity.getGeneralFeedback();
        Float defaultMark = updateQuestionEntity.getDefaultMark();
        QuestionDifficulty difficulty = updateQuestionEntity.getDifficulty();

        if (name == null)
            name = prevQuestion.getName();
        if (questionText == null)
            questionText = prevQuestion.getQuestionText();
        if (generalFeedback == null)
            generalFeedback = prevQuestion.getGeneralFeedback();
        if (defaultMark == null)
            defaultMark = prevQuestion.getDefaultMark();
        if (difficulty == null)
            difficulty = prevQuestion.getDifficulty();

        return Question.builder()
                .questionId(questionId)
                .organization(organization)
                .name(name)
                .questionText(questionText)
                .generalFeedback(generalFeedback)
                .defaultMark(defaultMark)
                .difficulty(difficulty)
                .updatedBy(User.builder()
                        .id(new UserId(updateQuestionEntity.getUpdatedBy()))
                        .build())
                .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .answers(answers)
                .qtype(qtype)
                .createdBy(createdBy)
                .build();
    }

    public AnswerOfQuestion answerOfQuestionUpdateEntityToAnswerOfQuestion(AnswerOfQuestionUpdateEntity answerOfQuestionUpdateEntity,
                                                                           QuestionId questionId) {
        return AnswerOfQuestion.builder()
                .id(new AnswerId(answerOfQuestionUpdateEntity.getAnswerId()))
                .questionId(questionId)
                .answer(answerOfQuestionUpdateEntity.getAnswer())
                .fraction(answerOfQuestionUpdateEntity.getFraction())
                .feedback(answerOfQuestionUpdateEntity.getFeedback())
                .build();
    }

    public UpdateQuestionResponse questionUpdatedEventToUpdateQuestionRespond(QuestionUpdatedEvent questionUpdatedEvent, String qtypeCodeQuestionUpdatedSuccessfully) {
        return UpdateQuestionResponse.builder()
                .questionId(questionUpdatedEvent.getQuestion().getId().getValue())
                .qtypeId(questionUpdatedEvent.getQtypeID())
                .message(qtypeCodeQuestionUpdatedSuccessfully)
                .build();
    }

    public QuestionEventPayload questionDeletedEventToQuestionEventPayload(QuestionDeletedEvent questionDeletedEvent) {
        return QuestionEventPayload.builder()
                .id(questionDeletedEvent.getQuestion().getId().getValue().toString())
                .sagaId(questionDeletedEvent.getQtypeID().toString())
                .organizationId(questionDeletedEvent.getQuestion().getOrganization().getId().getValue().toString())
                .createdBy(questionDeletedEvent.getQuestion().getCreatedBy().getId().getValue().toString())
                .updatedBy(questionDeletedEvent.getQuestion().getUpdatedBy().getId().getValue().toString())
                .difficulty(questionDeletedEvent.getQuestion().getDifficulty().name())
                .name(questionDeletedEvent.getQuestion().getName())
                .questionText(questionDeletedEvent.getQuestion().getQuestionText())
                .generalFeedback(questionDeletedEvent.getQuestion().getGeneralFeedback())
                .defaultMark(BigDecimal.valueOf(questionDeletedEvent.getQuestion().getDefaultMark()))
                .qType(questionDeletedEvent.getQuestion().getqtype().name())
                .answers(answerOfQuestionListToQuestionEventAnswerList(questionDeletedEvent.getQuestion().getAnswers()))
                .copyState(CopyState.DELETING)
                .createdAt(questionDeletedEvent.getQuestion().getCreatedAt())
                .updatedAt(questionDeletedEvent.getQuestion().getUpdatedAt())
                .build();
    }

    public QuestionEventPayload questionCreatedEventToQuestionEventPayload(QuestionCreatedEvent questionCreatedEvent) {
        return QuestionEventPayload.builder()
                .id(questionCreatedEvent.getQuestion().getId().getValue().toString())
                .sagaId(questionCreatedEvent.getQtypeID().toString())
                .organizationId(questionCreatedEvent.getQuestion().getOrganization().getId().getValue().toString())
                .createdBy(questionCreatedEvent.getQuestion().getCreatedBy().getId().getValue().toString())
                .updatedBy(questionCreatedEvent.getQuestion().getUpdatedBy().getId().getValue().toString())
                .difficulty(questionCreatedEvent.getQuestion().getDifficulty().name())
                .name(questionCreatedEvent.getQuestion().getName())
                .questionText(questionCreatedEvent.getQuestion().getQuestionText())
                .generalFeedback(questionCreatedEvent.getQuestion().getGeneralFeedback())
                .defaultMark(BigDecimal.valueOf(questionCreatedEvent.getQuestion().getDefaultMark()))
                .qType(questionCreatedEvent.getQuestion().getqtype().name())
                .answers(answerOfQuestionListToQuestionEventAnswerList(questionCreatedEvent.getQuestion().getAnswers()))
                .copyState(CopyState.CREATING)
                .createdAt(questionCreatedEvent.getQuestion().getCreatedAt())
                .updatedAt(questionCreatedEvent.getQuestion().getUpdatedAt())
                .build();
   }

    public QuestionEventPayload questionUpdatedEventToQuestionEventPayload(QuestionUpdatedEvent questionUpdatedEvent) {
          return QuestionEventPayload.builder()
                 .id(questionUpdatedEvent.getQuestion().getId().getValue().toString())
                 .sagaId(questionUpdatedEvent.getQtypeID().toString())
                 .organizationId(questionUpdatedEvent.getQuestion().getOrganization().getId().getValue().toString())
                 .createdBy(questionUpdatedEvent.getQuestion().getCreatedBy().getId().getValue().toString())
                 .updatedBy(questionUpdatedEvent.getQuestion().getUpdatedBy().getId().getValue().toString())
                 .difficulty(questionUpdatedEvent.getQuestion().getDifficulty().name())
                 .name(questionUpdatedEvent.getQuestion().getName())
                 .questionText(questionUpdatedEvent.getQuestion().getQuestionText())
                 .generalFeedback(questionUpdatedEvent.getQuestion().getGeneralFeedback())
                 .defaultMark(BigDecimal.valueOf(questionUpdatedEvent.getQuestion().getDefaultMark()))
                 .qType(questionUpdatedEvent.getQuestion().getqtype().name())
                 .answers(answerOfQuestionListToQuestionEventAnswerList(questionUpdatedEvent.getQuestion().getAnswers()))
                 .copyState(CopyState.UPDATING)
                 .createdAt(questionUpdatedEvent.getQuestion().getCreatedAt())
                 .updatedAt(questionUpdatedEvent.getQuestion().getUpdatedAt())
                 .build();
    }

    private QuestionEventAnswer answerOfQuestionToQuestionEventAnswer(AnswerOfQuestion answerOfQuestion) {
        return QuestionEventAnswer.builder()
                .id(answerOfQuestion.getId().getValue().toString())
                .questionId(answerOfQuestion.getQuestionId().getValue().toString())
                .answer(answerOfQuestion.getAnswer())
                .fraction(answerOfQuestion.getFraction())
                .feedback(answerOfQuestion.getFeedback())
                .build();
    }

    private List<QuestionEventAnswer> answerOfQuestionListToQuestionEventAnswerList(List<AnswerOfQuestion> answerOfQuestions) {
        if (answerOfQuestions == null) return null;

        return List.of(answerOfQuestions.stream()
                .map(this::answerOfQuestionToQuestionEventAnswer)
                .toArray(QuestionEventAnswer[]::new));
    }

    private QuestionEventQtypeEssay qtypeEssayQuestionToQuestionEventQtypeEssay(QtypeEssayQuestion qtypeEssayQuestion) {
        return QuestionEventQtypeEssay.builder()
                .id(qtypeEssayQuestion.getId().getValue().toString())
                .questionId(qtypeEssayQuestion.getQuestion().getId().getValue().toString())
                .responseFormat(qtypeEssayQuestion.getResponseFormat())
                .responseRequired(qtypeEssayQuestion.getResponseRequired())
                .responseFieldLines(qtypeEssayQuestion.getResponseFieldLines())
                .minWordLimit(qtypeEssayQuestion.getMinWordLimit())
                .maxWordLimit(qtypeEssayQuestion.getMaxWordLimit())
                .attachments(qtypeEssayQuestion.getAttachments())
                .attachmentsRequired(qtypeEssayQuestion.getAttachmentsRequired())
                .graderInfo(qtypeEssayQuestion.getGraderInfo())
                .graderInfoFormat(qtypeEssayQuestion.getGraderInfoFormat())
                .responseTemplate(qtypeEssayQuestion.getResponseTemplate())
                .maxBytes(qtypeEssayQuestion.getMaxBytes())
                .fileTypesList(qtypeEssayQuestion.getFileTypesList())
                .build();
    }

    private QuestionEventQtypeCode qtypeCodeQuestionToQuestionEventQtypeCode(QtypeCodeQuestion qtypeCodeQuestion) {
        return QuestionEventQtypeCode.builder()
                .id(qtypeCodeQuestion.getId().getValue().toString())
                .questionId(qtypeCodeQuestion.getQuestion().getId().getValue().toString())
                .dslTemplate(qtypeCodeQuestion.getDslTemplate())
                .build();
    }

    private QuestionEventQtypeMultichoice qtypeMultichoiceQuestionToQuestionEventQtypeMultichoice(QtypeMultiChoiceQuestion qtypeMultichoiceQuestion) {
        return QuestionEventQtypeMultichoice.builder()
                .id(qtypeMultichoiceQuestion.getId().getValue().toString())
                .questionId(qtypeMultichoiceQuestion.getQuestion().getId().getValue().toString())
                .single(qtypeMultichoiceQuestion.getSingle())
                .shuffleAnswers(qtypeMultichoiceQuestion.getShuffleAnswers())
                .answerNumbering(qtypeMultichoiceQuestion.getAnswerNumbering())
                .correctFeedback(qtypeMultichoiceQuestion.getCorrectFeedback())
                .partiallyCorrectFeedback(qtypeMultichoiceQuestion.getPartiallyCorrectFeedback())
                .incorrectFeedback(qtypeMultichoiceQuestion.getIncorrectFeedback())
                .showNumCorrect(qtypeMultichoiceQuestion.getShowNumCorrect())
                .showStandardInstructions(qtypeMultichoiceQuestion.getShowStandardInstructions())
                .build();
    }

    private QuestionEventQtypeShortanswer qtypeShortanswerQuestionToQuestionEventQtypeShortanswer(QtypeShortAnswerQuestion qtypeShortanswerQuestion) {
        return QuestionEventQtypeShortanswer.builder()
                .id(qtypeShortanswerQuestion.getId().getValue().toString())
                .questionId(qtypeShortanswerQuestion.getQuestion().getId().getValue().toString())
                .caseSensitive(qtypeShortanswerQuestion.getCaseSensitive())
                .build();
    }

    public QuestionEventPreviousPayload questionDeletedEventToQuestionEventPreviousPayload(QuestionDeletedEvent questionDeletedEvent) {
        QuestionEventQtypeCode qtypeCodeQuestion = null;
        QuestionEventQtypeEssay qtypeEssayQuestion = null;
        QuestionEventQtypeMultichoice qtypeMultichoiceQuestion = null;
        QuestionEventQtypeShortanswer qtypeShortanswerQuestion = null;

        switch (questionDeletedEvent.getQuestion().getqtype()) {
            case CODE:
                qtypeCodeQuestion = qtypeCodeQuestionToQuestionEventQtypeCode(questionDeletedEvent.getQtypeCodeQuestion());
                break;
            case SHORT_ANSWER:
                qtypeShortanswerQuestion = qtypeShortanswerQuestionToQuestionEventQtypeShortanswer(questionDeletedEvent.getQtypeShortAnswerQuestion());
                break;
            case ESSAY:
                qtypeEssayQuestion = qtypeEssayQuestionToQuestionEventQtypeEssay(questionDeletedEvent.getQtypeEssayQuestion());
                break;
            case MULTIPLE_CHOICE, TRUE_FALSE:
                qtypeMultichoiceQuestion = qtypeMultichoiceQuestionToQuestionEventQtypeMultichoice(questionDeletedEvent.getQtypeMultiChoiceQuestion());
                break;
        }

        return QuestionEventPreviousPayload.builder()
                .id(questionDeletedEvent.getQuestion().getId().getValue().toString())
                .sagaId(questionDeletedEvent.getQtypeID().toString())
                .organizationId(questionDeletedEvent.getQuestion().getOrganization().getId().getValue().toString())
                .createdBy(questionDeletedEvent.getQuestion().getCreatedBy().getId().getValue().toString())
                .updatedBy(questionDeletedEvent.getQuestion().getUpdatedBy().getId().getValue().toString())
                .difficulty(questionDeletedEvent.getQuestion().getDifficulty().name())
                .name(questionDeletedEvent.getQuestion().getName())
                .questionText(questionDeletedEvent.getQuestion().getQuestionText())
                .generalFeedback(questionDeletedEvent.getQuestion().getGeneralFeedback())
                .defaultMark(BigDecimal.valueOf(questionDeletedEvent.getQuestion().getDefaultMark()))
                .qType(questionDeletedEvent.getQuestion().getqtype().name())
                .answers(answerOfQuestionListToQuestionEventAnswerList(questionDeletedEvent.getQuestion().getAnswers()))
                .copyState(questionDeletedEvent.getQuestion().getCopyState())
                .createdAt(questionDeletedEvent.getQuestion().getCreatedAt())
                .updatedAt(questionDeletedEvent.getQuestion().getUpdatedAt())
                .qtypeCodeQuestion(qtypeCodeQuestion)
                .qtypeEssayQuestion(qtypeEssayQuestion)
                .qtypeMultichoiceQuestion(qtypeMultichoiceQuestion)
                .qtypeShortanswerQuestion(qtypeShortanswerQuestion)
                .build();
    }

    public QuestionEventPreviousPayload questionUpdatedEventToQuestionEventPreviousPayload(QuestionUpdatedEvent questionUpdatedEvent) {
        QuestionEventQtypeCode qtypeCodeQuestion = null;
        QuestionEventQtypeEssay qtypeEssayQuestion = null;
        QuestionEventQtypeMultichoice qtypeMultichoiceQuestion = null;
        QuestionEventQtypeShortanswer qtypeShortanswerQuestion = null;

        switch (questionUpdatedEvent.getQuestion().getqtype()) {
            case CODE:
                qtypeCodeQuestion = qtypeCodeQuestionToQuestionEventQtypeCode(questionUpdatedEvent.getQtypeCodeQuestion());
                break;
            case SHORT_ANSWER:
                qtypeShortanswerQuestion = qtypeShortanswerQuestionToQuestionEventQtypeShortanswer(questionUpdatedEvent.getQtypeShortAnswerQuestion());
                break;
            case ESSAY:
                qtypeEssayQuestion = qtypeEssayQuestionToQuestionEventQtypeEssay(questionUpdatedEvent.getQtypeEssayQuestion());
                break;
            case MULTIPLE_CHOICE, TRUE_FALSE:
                qtypeMultichoiceQuestion = qtypeMultichoiceQuestionToQuestionEventQtypeMultichoice(questionUpdatedEvent.getQtypeMultiChoiceQuestion());
                break;
        }

        return QuestionEventPreviousPayload.builder()
                .id(questionUpdatedEvent.getQuestion().getId().getValue().toString())
                .sagaId(questionUpdatedEvent.getQtypeID().toString())
                .organizationId(questionUpdatedEvent.getQuestion().getOrganization().getId().getValue().toString())
                .createdBy(questionUpdatedEvent.getQuestion().getCreatedBy().getId().getValue().toString())
                .updatedBy(questionUpdatedEvent.getQuestion().getUpdatedBy().getId().getValue().toString())
                .difficulty(questionUpdatedEvent.getQuestion().getDifficulty().name())
                .name(questionUpdatedEvent.getQuestion().getName())
                .questionText(questionUpdatedEvent.getQuestion().getQuestionText())
                .generalFeedback(questionUpdatedEvent.getQuestion().getGeneralFeedback())
                .defaultMark(BigDecimal.valueOf(questionUpdatedEvent.getQuestion().getDefaultMark()))
                .qType(questionUpdatedEvent.getQuestion().getqtype().name())
                .answers(answerOfQuestionListToQuestionEventAnswerList(questionUpdatedEvent.getQuestion().getAnswers()))
                .copyState(questionUpdatedEvent.getPrevQuestion().getCopyState())
                .createdAt(questionUpdatedEvent.getQuestion().getCreatedAt())
                .updatedAt(questionUpdatedEvent.getQuestion().getUpdatedAt())
                .qtypeCodeQuestion(qtypeCodeQuestion)
                .qtypeEssayQuestion(qtypeEssayQuestion)
                .qtypeMultichoiceQuestion(qtypeMultichoiceQuestion)
                .qtypeShortanswerQuestion(qtypeShortanswerQuestion)
                .build();
    }

    public CodeQuestionDeleteEventPayload questionDeletedEventToCodeQuestionsDeleteEventPayload(QuestionDeletedEvent questionDeletedEvent) {
        return CodeQuestionDeleteEventPayload.builder()
                .id(questionDeletedEvent.getQuestion().getId().getValue().toString())
                .codeQuestionId(questionDeletedEvent.getQtypeID().toString())
                .sagaId(questionDeletedEvent.getQtypeID().toString())
                .questionId(questionDeletedEvent.getQuestion().getId().getValue().toString())
                .state(questionDeletedEvent.getQuestion().getCopyState().name())
                .build();
    }

    private AnswerOfQuestionResponseEntity answerOfQuestionToAnswerOfQuestionResponseEntity(AnswerOfQuestion answerOfQuestion) {
        return AnswerOfQuestionResponseEntity.builder()
                .id(answerOfQuestion.getId().getValue().toString())
                .questionId(answerOfQuestion.getQuestionId().getValue().toString())
                .answer(answerOfQuestion.getAnswer())
                .fraction(answerOfQuestion.getFraction())
                .feedback(answerOfQuestion.getFeedback())
                .build();
    }

    private List<AnswerOfQuestionResponseEntity> answerOfQuestionListToAnswerOfQuestionResponseEntityList(List<AnswerOfQuestion> answers) {
        return List.of(answers.stream()
                .map(this::answerOfQuestionToAnswerOfQuestionResponseEntity)
                .toArray(AnswerOfQuestionResponseEntity[]::new));
    }

    public CreateQuestionCloneResponse questionListToCreateQuestionCloneResponse(List<Question> questions) {
        return CreateQuestionCloneResponse.builder()
                .questions(questions.stream()
                        .map(this::questionToQuestionResponseEntity)
                        .toList())
                .build();
    }

    private GetAllQuestionPaginationResponseEntity questionToGetAllQuestionPaginationResponseEntity(Question question) {
        return GetAllQuestionPaginationResponseEntity.builder()
                .questionId(question.getId().getValue().toString())
                .name(question.getName())
                .difficulty(question.getDifficulty().name())
                .questionText(question.getQuestionText())
                .build();
    }

    public QueryAllQuestionWithPaginationResponse questionPageToQueryAllQuestionWithPaginationResponse(Page<Question> questions) {
        return QueryAllQuestionWithPaginationResponse.builder()
                .questions(questions.getContent().stream()
                        .map(this::questionToGetAllQuestionPaginationResponseEntity)
                        .toList())
                .currentPage(questions.getNumber())
                .totalItems(questions.getTotalElements())
                .totalPages(questions.getTotalPages())
                .build();
    }

    public List<QueryAnswerOfQuestionResponse> answerOfQuestionToQueryAnswerOfQuestionResponse(List<AnswerOfQuestion> answerOfQuestions) {
        return List.of(answerOfQuestions.stream()
                .map(answerOfQuestion -> QueryAnswerOfQuestionResponse.builder()
                        .answerId(answerOfQuestion.getId().getValue())
                        .questionId(answerOfQuestion.getQuestionId().getValue())
                        .feedback(answerOfQuestion.getFeedback())
                        .answer(answerOfQuestion.getAnswer())
                        .fraction(answerOfQuestion.getFraction())
                        .build())
                .toArray(QueryAnswerOfQuestionResponse[]::new));
    }
}
