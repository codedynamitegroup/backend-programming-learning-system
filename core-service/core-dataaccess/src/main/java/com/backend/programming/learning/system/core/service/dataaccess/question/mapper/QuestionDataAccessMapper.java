package com.backend.programming.learning.system.core.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.core.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.organization.repository.OrganizationJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.exception.OrganizationNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class QuestionDataAccessMapper {
    private final OrganizationJpaRepository organizationJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;
    private final OrganizationDataAccessMapper organizationDataAccessMapper;

    public QuestionDataAccessMapper(OrganizationJpaRepository organizationJpaRepository,
                                    UserJpaRepository userJpaRepository,
                                    UserDataAccessMapper userDataAccessMapper,
                                    OrganizationDataAccessMapper organizationDataAccessMapper) {
        this.organizationJpaRepository = organizationJpaRepository;
        this.userJpaRepository = userJpaRepository;
        this.userDataAccessMapper = userDataAccessMapper;
        this.organizationDataAccessMapper = organizationDataAccessMapper;
    }

    public QuestionEntity questionToQuestionEntity(Question question) {
        OrganizationEntity organization = organizationJpaRepository
                .findById(question.getOrganization().getId().getValue())
                .orElseThrow(
                        () -> new OrganizationNotFoundException("Organization with id: " + question
                                .getOrganization()
                                .getId().getValue() + " could not be found!"));
        UserEntity createdBy = userJpaRepository
                .findById(question.getCreatedBy().getId().getValue())
                .orElseThrow(() ->
                        new UserNotFoundException("User with id: " + question
                                .getCreatedBy()
                                .getId()
                                .getValue() + " could not be found!"));
        UserEntity updatedBy = userJpaRepository
                .findById(question.getUpdatedBy().getId().getValue())
                .orElseThrow(() ->
                        new UserNotFoundException("User with id: " + question
                                .getUpdatedBy()
                                .getId()
                                .getValue() + " could not be found!"));

        return QuestionEntity.builder()
                .id(question.getId().getValue())
                .organization(organization)
                .difficulty(question.getDifficulty())
                .name(question.getName())
                .questionText(question.getQuestionText())
                .generalFeedback(question.getGeneralFeedback())
                .defaultMark(BigDecimal.valueOf(question.getDefaultMark()))
                .createdBy(createdBy)
                .updatedBy(updatedBy)
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
}
