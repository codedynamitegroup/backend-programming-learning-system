package com.backend.programming.learning.system.course.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import com.backend.programming.learning.system.entity.Organization;
import com.backend.programming.learning.system.entity.Question;
import com.backend.programming.learning.system.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionDataAccessMapper {
    private final OrganizationDataAccessMapper organizationDataAccessMapper;
    private final UserDataAccessMapper userDataAccessMapper;

    public QuestionEntity questionToQuestionEntity(Question question) {
        OrganizationEntity organizationEntity = organizationDataAccessMapper.organizationToOrganizationEntity(question.getOrganization());
        UserEntity createdBy = userDataAccessMapper.userToUserEntity(question.getCreatedBy());
        return QuestionEntity.builder()
                .id(question.getId().getValue())
                .organization(organizationEntity)
                .name(question.getName())
                .questionText(question.getQuestionText())
                .generalFeedback(question.getGeneralFeedback())
                .defaultMark(question.getDefaultMark())
                .qtype(question.getqtype())
                .difficulty(question.getDifficulty())
                .createdBy(createdBy)
                .updatedBy(createdBy)
                .build();
    }

    public Question questionEntityToQuestion(QuestionEntity questionEntity) {
        Organization organization = organizationDataAccessMapper.organizationEntityToOrganization(questionEntity.getOrganization());
        User createdBy = userDataAccessMapper.userEntityToUser(questionEntity.getCreatedBy());
        User updatedBy = userDataAccessMapper.userEntityToUser(questionEntity.getUpdatedBy());
        return Question.builder()
                .id(new QuestionId(questionEntity.getId()))
                .name(questionEntity.getName())
                .questionText(questionEntity.getQuestionText())
                .generalFeedback(questionEntity.getGeneralFeedback())
                .defaultMark(questionEntity.getDefaultMark())
                .qtype(questionEntity.getQtype())
                .difficulty(questionEntity.getDifficulty())
                .organization(organization)
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .build();
    }
}
