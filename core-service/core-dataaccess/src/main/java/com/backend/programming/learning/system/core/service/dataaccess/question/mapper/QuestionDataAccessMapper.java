package com.backend.programming.learning.system.core.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeCodeQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeEssayQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeMultichoiceQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeShortanswerQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class QuestionDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;
    private final OrganizationDataAccessMapper organizationDataAccessMapper;
    private final AnswerOfQuestionDataAccessMapper answerOfQuestionDataAccessMapper;

    public QuestionDataAccessMapper(UserDataAccessMapper userDataAccessMapper,
                                    OrganizationDataAccessMapper organizationDataAccessMapper,
                                    AnswerOfQuestionDataAccessMapper answerOfQuestionDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
        this.organizationDataAccessMapper = organizationDataAccessMapper;
        this.answerOfQuestionDataAccessMapper = answerOfQuestionDataAccessMapper;
    }

    public QuestionEntity questionToQuestionEntity(Question question) {
        QuestionEntity.QuestionEntityBuilder builder = QuestionEntity.builder();

        if (question.getId() != null)
            builder.id(question.getId().getValue());
        if (question.getOrganization() != null)
            builder.organization(organizationDataAccessMapper.organizationToOrganizationEntity(question.getOrganization()));
        if (question.getDifficulty() != null)
            builder.difficulty(question.getDifficulty());
        if (question.getName() != null)
            builder.name(question.getName());
        if (question.getQuestionText() != null)
            builder.questionText(question.getQuestionText());
        if (question.getGeneralFeedback() != null)
            builder.generalFeedback(question.getGeneralFeedback());
        if (question.getDefaultMark() != null)
            builder.defaultMark(BigDecimal.valueOf(question.getDefaultMark()));
        if (question.getCreatedBy() != null)
            builder.createdBy(userDataAccessMapper.userToUserEntity(question.getCreatedBy()));
        if (question.getUpdatedBy() != null)
            builder.updatedBy(userDataAccessMapper.userToUserEntity(question.getUpdatedBy()));
        if (question.getqtype() != null)
            builder.qtype(question.getqtype());
        if (question.getCreatedAt() != null)
            builder.createdAt(question.getCreatedAt());
        if (question.getUpdatedAt() != null)
            builder.updatedAt(question.getUpdatedAt());
        if(question.getAnswers() != null)
            builder.answerOfQuestions(answerOfQuestionDataAccessMapper.answerOfQuestionListToAnswerOfQuestionEntityList(question.getAnswers()));
        if (question.getCopyState() != null)
            builder.copyState(question.getCopyState());
        if (question.getQuestionBankCategoryId() != null)
            builder.questionBankCategoryId(question.getQuestionBankCategoryId());
        if (question.getIsOrgQuestionBank() != null)
            builder.isOrgQuestionBank(question.getIsOrgQuestionBank());
        return builder.build();
    }

    public Question questionEntityToQuestion(QuestionEntity questionEntity) {
        // TODO: add failure messages
        return Question.builder()
                .questionId(new QuestionId(questionEntity.getId()))
                .organization(organizationDataAccessMapper.organizationEntityToOrganizationHideSensitiveData(questionEntity.getOrganization()))
                .difficulty(questionEntity.getDifficulty())
                .name(questionEntity.getName())
                .questionText(questionEntity.getQuestionText())
                .generalFeedback(questionEntity.getGeneralFeedback())
                .defaultMark(questionEntity.getDefaultMark().floatValue())
                .createdBy(userDataAccessMapper.userEntityToUserHideSensitiveData(questionEntity.getCreatedBy()))
                .updatedBy(userDataAccessMapper.userEntityToUserHideSensitiveData(questionEntity.getCreatedBy()))
                .qtype(questionEntity.getQtype())
                .failureMessages(null)
                .createdAt(questionEntity.getCreatedAt())
                .updatedAt(questionEntity.getUpdatedAt())
                .answers(answerOfQuestionDataAccessMapper.answerOfQuestionEntityListToAnswerOfQuestionList(questionEntity.getAnswerOfQuestions()))
                .copyState(questionEntity.getCopyState())
                .questionBankCategoryId(questionEntity.getQuestionBankCategoryId())
                .isOrgQuestionBank(questionEntity.getIsOrgQuestionBank())
                .build();
    }

    public QuestionEntity setQuestionEntity(QuestionEntity questionEntity, Question question) {
        if (question.getId() != null)
            questionEntity.setId(question.getId().getValue());
        if (question.getDifficulty() != null)
            questionEntity.setDifficulty(question.getDifficulty());
        if (question.getName() != null)
            questionEntity.setName(question.getName());
        if (question.getQuestionText() != null)
            questionEntity.setQuestionText(question.getQuestionText());
        if (question.getGeneralFeedback() != null)
            questionEntity.setGeneralFeedback(question.getGeneralFeedback());
        if (question.getDefaultMark() != null)
            questionEntity.setDefaultMark(BigDecimal.valueOf(question.getDefaultMark()));
        if (question.getqtype() != null)
            questionEntity.setQtype(question.getqtype());
        if (question.getAnswers() != null)
            questionEntity.setAnswerOfQuestions(answerOfQuestionDataAccessMapper
                    .setAnswerOfQuestionEntityList(questionEntity.getAnswerOfQuestions(), question.getAnswers()));
        if (question.getCopyState() != null)
            questionEntity.setCopyState(question.getCopyState());

        return questionEntity;
    }

    public QuestionResponseEntity questionEntityToQuestionResponseEntity(QuestionEntity questionEntity) {
        return QuestionResponseEntity.builder()
                .id(questionEntity.getId().toString())
                .organization(organizationDataAccessMapper
                        .organizationEntityToOrganizationResponseEntity(questionEntity.getOrganization()))
                .difficulty(questionEntity.getDifficulty())
                .name(questionEntity.getName())
                .questionText(questionEntity.getQuestionText())
                .generalFeedback(questionEntity.getGeneralFeedback())
                .defaultMark(questionEntity.getDefaultMark().floatValue())
                .createdBy(userDataAccessMapper.userEntityToUserResponseEntityHideSensitiveData(questionEntity.getCreatedBy()))
                .updatedBy(userDataAccessMapper.userEntityToUserResponseEntityHideSensitiveData(questionEntity.getUpdatedBy()))
                .qtype(questionEntity.getQtype())
                .failureMessages(null)
                .createdAt(questionEntity.getCreatedAt())
                .updatedAt(questionEntity.getUpdatedAt())
                .answers(answerOfQuestionDataAccessMapper
                        .answerOfQuestionEntityListToAnswerOfQuestionResponseEntityList(questionEntity.getAnswerOfQuestions()))
                .build();
    }

    public QuestionEntity cloneQuestionEntity(QuestionEntity questionEntity) {
        return QuestionEntity.builder()
                .id(UUID.randomUUID())
                .organization(questionEntity.getOrganization())
                .difficulty(questionEntity.getDifficulty())
                .name(questionEntity.getName())
                .questionText(questionEntity.getQuestionText())
                .generalFeedback(questionEntity.getGeneralFeedback())
                .defaultMark(questionEntity.getDefaultMark())
                .createdBy(questionEntity.getCreatedBy())
                .updatedBy(questionEntity.getUpdatedBy())
                .qtype(questionEntity.getQtype())
                .createdAt(questionEntity.getCreatedAt())
                .updatedAt(questionEntity.getUpdatedAt())
                .answerOfQuestions(questionEntity.getAnswerOfQuestions())
                .copyState(questionEntity.getCopyState())
                .isOrgQuestionBank(questionEntity.getIsOrgQuestionBank())
                .build();
    }

    public QtypeShortanswerQuestionEntity cloneQtypeShortanswerQuestionEntity(
            QtypeShortanswerQuestionEntity qtypeShortanswerQuestion, QuestionEntity newQuestion) {
        return QtypeShortanswerQuestionEntity.builder()
                .id(UUID.randomUUID())
                .question(newQuestion)
                .caseSensitive(qtypeShortanswerQuestion.getCaseSensitive())
                .build();
    }

    public QtypeMultichoiceQuestionEntity cloneQtypeMultichoiceQuestionEntity(QtypeMultichoiceQuestionEntity qtypeMultichoiceQuestion, QuestionEntity newQuestion) {
        return QtypeMultichoiceQuestionEntity.builder()
                .id(UUID.randomUUID())
                .question(newQuestion)
                .single(qtypeMultichoiceQuestion.getSingle())
                .shuffleAnswers(qtypeMultichoiceQuestion.getShuffleAnswers())
                .correctFeedback(qtypeMultichoiceQuestion.getCorrectFeedback())
                .partiallyCorrectFeedback(qtypeMultichoiceQuestion.getPartiallyCorrectFeedback())
                .incorrectFeedback(qtypeMultichoiceQuestion.getIncorrectFeedback())
                .answerNumbering(qtypeMultichoiceQuestion.getAnswerNumbering())
                .showNumCorrect(qtypeMultichoiceQuestion.getShowNumCorrect())
                .showStandardInstruction(qtypeMultichoiceQuestion.getShowStandardInstruction())
                .build();
    }

    public QtypeEssayQuestionEntity cloneQtypeEssayQuestionEntity(QtypeEssayQuestionEntity qtypeEssayQuestion, QuestionEntity newQuestion) {
        return QtypeEssayQuestionEntity.builder()
                .id(UUID.randomUUID())
                .question(newQuestion)
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

    public QtypeCodeQuestionEntity cloneQtypeCodeQuestionEntity(QtypeCodeQuestionEntity qtypeCodeQuestion, QuestionEntity newQuestion) {
        return QtypeCodeQuestionEntity.builder()
                .id(UUID.randomUUID())
                .question(newQuestion)
                .dslTemplate(qtypeCodeQuestion.getDslTemplate())
                .problemStatement(qtypeCodeQuestion.getProblemStatement())
                .name(qtypeCodeQuestion.getName())
                .maxGrade(qtypeCodeQuestion.getMaxGrade())
                .build();
    }
}
