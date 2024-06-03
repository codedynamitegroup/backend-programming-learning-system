package com.backend.programming.learning.system.course.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionExamDataAccessDTO;
import com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.mapper.QuestionBankCategoryDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question.QuestionExamDTO;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.QuestionBankCategoryId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class QuestionDataAccessMapper {
    private final OrganizationDataAccessMapper organizationDataAccessMapper;
    private final UserDataAccessMapper userDataAccessMapper;
    private final QuestionBankCategoryDataAccessMapper questionBankCategoryDataAccessMapper;

    public QuestionEntity questionToQuestionEntity(Question question) {
        OrganizationEntity organizationEntity = organizationDataAccessMapper.organizationToOrganizationEntity(question.getOrganization());
        UserEntity createdBy = userDataAccessMapper.userToUserEntity(question.getCreatedBy());
        QuestionBankCategoryId questionBankCategoryId = question.getQuestionBankCategory() != null ?
               new QuestionBankCategoryId(questionBankCategoryDataAccessMapper
                       .questionBankCategoryToQuestionBankCategoryEntity(question.getQuestionBankCategory()).getId()) : null;
        return QuestionEntity.builder()
                .id(question.getId().getValue())
                .organization(organizationEntity)
                .name(question.getName())
                .questionText(question.getQuestionText())
                .generalFeedback(question.getGeneralFeedback())
                .defaultMark(question.getDefaultMark())
                .qtype(question.getQtype())
                .difficulty(question.getDifficulty())
                .questionBankCategoryId(Objects.nonNull(questionBankCategoryId) ? questionBankCategoryId.getValue() : null)
                .createdBy(createdBy)
                .updatedBy(createdBy)
                .createdAt(question.getCreatedAt())
                .updatedAt(question.getUpdatedAt())
                .build();
    }

    public Question questionEntityToQuestion(QuestionEntity questionEntity) {
        Organization organization = organizationDataAccessMapper.organizationEntityToOrganization(questionEntity.getOrganization());
        User createdBy = userDataAccessMapper.userEntityToUser(questionEntity.getCreatedBy());
        User updatedBy = userDataAccessMapper.userEntityToUser(questionEntity.getUpdatedBy());
        Question response = Question.builder()
                .name(questionEntity.getName())
                .questionText(questionEntity.getQuestionText())
                .generalFeedback(questionEntity.getGeneralFeedback())
                .defaultMark(questionEntity.getDefaultMark())
                .qtype(questionEntity.getQtype())
                .difficulty(questionEntity.getDifficulty())
                .organization(organization)
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(questionEntity.getCreatedAt())
                .updatedAt(questionEntity.getUpdatedAt())
                .build();
        response.setId(new QuestionId(questionEntity.getId()));
        return response;
    }

    private QuestionExamDTO questionDTOtoQuestion(QuestionExamDataAccessDTO questionEntity) {
        return
                QuestionExamDTO.builder()
                .id(questionEntity.getId())
                .difficulty(questionEntity.getDifficulty())
                .name(questionEntity.getName())
                .questionText(questionEntity.getQuestionText())
                .qtype(questionEntity.getQtype())
                .page(questionEntity.getPage())
                .build();
    }

    public List<QuestionExamDTO> questionEntitiesToQuestions(List<QuestionExamDataAccessDTO> questionEntities) {
        return questionEntities.stream().map(this::questionDTOtoQuestion).toList();
    }
}
