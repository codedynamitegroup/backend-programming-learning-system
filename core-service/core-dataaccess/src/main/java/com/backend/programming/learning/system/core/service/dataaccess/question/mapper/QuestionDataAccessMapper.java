package com.backend.programming.learning.system.core.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

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

        return builder.build();
    }

    public Question questionEntityToQuestion(QuestionEntity questionEntity) {
        // TODO: add failure messages
        return Question.builder()
                .questionId(new QuestionId(questionEntity.getId()))
                .organization(organizationDataAccessMapper.organizationEntityToOrganization(questionEntity.getOrganization()))
                .difficulty(questionEntity.getDifficulty())
                .name(questionEntity.getName())
                .questionText(questionEntity.getQuestionText())
                .generalFeedback(questionEntity.getGeneralFeedback())
                .defaultMark(questionEntity.getDefaultMark().floatValue())
                .createdBy(userDataAccessMapper.userEntityToUser(questionEntity.getCreatedBy()))
                .updatedBy(userDataAccessMapper.userEntityToUser(questionEntity.getCreatedBy()))
                .qtype(questionEntity.getQtype())
                .failureMessages(null)
                .createdAt(questionEntity.getCreatedAt())
                .updatedAt(questionEntity.getUpdatedAt())
                .answers(answerOfQuestionDataAccessMapper.answerOfQuestionEntityListToAnswerOfQuestionList(questionEntity.getAnswerOfQuestions()))
                .build();
    }

    public QuestionEntity setQuestionEntity(QuestionEntity questionEntity, Question question) {
        if (question.getId() != null)
            questionEntity.setId(question.getId().getValue());
        if (question.getOrganization() != null)
            questionEntity.setOrganization(organizationDataAccessMapper.organizationToOrganizationEntity(question.getOrganization()));
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
        if (question.getCreatedBy() != null)
            questionEntity.setCreatedBy(userDataAccessMapper.userToUserEntity(question.getCreatedBy()));
        if (question.getUpdatedBy() != null)
            questionEntity.setUpdatedBy(userDataAccessMapper.userToUserEntity(question.getUpdatedBy()));
        if (question.getqtype() != null)
            questionEntity.setQtype(question.getqtype());
        if (question.getAnswers() != null)
            questionEntity.setAnswerOfQuestions(answerOfQuestionDataAccessMapper
                    .setAnswerOfQuestionEntityList(questionEntity.getAnswerOfQuestions(), question.getAnswers()));

        return questionEntity;
    }

    public QuestionResponseEntity questionEntityToQuestionResponseEntity(QuestionEntity questionEntity) {
        return QuestionResponseEntity.builder()
                .id(questionEntity.getId().toString())
                .organization(organizationDataAccessMapper.organizationEntityToOrganization(questionEntity.getOrganization()))
                .difficulty(questionEntity.getDifficulty())
                .name(questionEntity.getName())
                .questionText(questionEntity.getQuestionText())
                .generalFeedback(questionEntity.getGeneralFeedback())
                .defaultMark(questionEntity.getDefaultMark().floatValue())
                .createdBy(userDataAccessMapper.userEntityToUser(questionEntity.getCreatedBy()))
                .updatedBy(userDataAccessMapper.userEntityToUser(questionEntity.getUpdatedBy()))
                .qtype(questionEntity.getQtype())
                .failureMessages(null)
                .createdAt(questionEntity.getCreatedAt())
                .updatedAt(questionEntity.getUpdatedAt())
                .answers(answerOfQuestionDataAccessMapper.answerOfQuestionEntityListToAnswerOfQuestionList(questionEntity.getAnswerOfQuestions()))
                .build();
    }
}
