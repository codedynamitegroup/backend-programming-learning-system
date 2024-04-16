package com.backend.programming.learning.system.core.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QuestionResponseEntity;
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
        return QuestionEntity.builder()
                .id(question.getId().getValue())
                .organization(organizationDataAccessMapper.organizationToOrganizationEntity(question.getOrganization()))
                .difficulty(question.getDifficulty())
                .name(question.getName())
                .questionText(question.getQuestionText())
                .generalFeedback(question.getGeneralFeedback())
                .defaultMark(BigDecimal.valueOf(question.getDefaultMark()))
                .createdBy(userDataAccessMapper.userToUserEntity(question.getCreatedBy()))
                .updatedBy(userDataAccessMapper.userToUserEntity(question.getUpdatedBy()))
                .qtype(question.getqtype())
                .createdAt(question.getCreatedAt())
                .updatedAt(question.getUpdatedAt())
                .build();
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
                .build();
    }

    public QuestionResponseEntity questionEntityToQuestionResponseEntity(QuestionEntity questionEntity) {
        return QuestionResponseEntity.builder()
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
