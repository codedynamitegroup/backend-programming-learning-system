package com.backend.programming.learning.system.core.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.organization.repository.OrganizationJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class QuestionDataAccessMapper {
    private final OrganizationJpaRepository organizationJpaRepository;
    private final UserJpaRepository userJpaRepository;

    public QuestionDataAccessMapper(OrganizationJpaRepository organizationJpaRepository,
                                    UserJpaRepository userJpaRepository) {
        this.organizationJpaRepository = organizationJpaRepository;
        this.userJpaRepository = userJpaRepository;
    }

    public QuestionEntity questionToQuestionEntity(Question question) {
        OrganizationEntity organization = organizationJpaRepository
                .findById(question.getOrganizationId().getValue())
                .orElseThrow();

        UserEntity createdBy = userJpaRepository
                .findById(question.getCreatedBy().getValue())
                .orElseThrow();
        UserEntity updatedBy = userJpaRepository
                .findById(question.getUpdatedBy().getValue())
                .orElseThrow();

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
                .organizationId(new OrganizationId(questionEntity.getOrganization().getId()))
                .difficulty(questionEntity.getDifficulty())
                .name(questionEntity.getName())
                .questionText(questionEntity.getQuestionText())
                .generalFeedback(questionEntity.getGeneralFeedback())
                .defaultMark(questionEntity.getDefaultMark().floatValue())
                .createdBy(new UserId(questionEntity.getCreatedBy().getId()))
                .updatedBy(new UserId(questionEntity.getUpdatedBy().getId()))
                .qtype(questionEntity.getQtype())
                .failureMessages(null)
                .createdAt(questionEntity.getCreatedAt())
                .updatedAt(questionEntity.getUpdatedAt())
                .build();
    }
}
