package com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.entity.QuestionBankCategoryEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionBankCategory;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.QuestionBankCategoryId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionBankCategoryDataAccessMapper {
    final UserDataAccessMapper userDataAccessMapper;
    public QuestionBankCategoryEntity questionBankCategoryToQuestionBankCategoryEntity(QuestionBankCategory questionBankCategory) {
        UserEntity createdBy = userDataAccessMapper.userToUserEntity(questionBankCategory.getCreatedBy());
        UserEntity updatedBy = userDataAccessMapper.userToUserEntity(questionBankCategory.getUpdatedBy());
        return QuestionBankCategoryEntity.builder()
                .id(questionBankCategory.getId().getValue())
                .name(questionBankCategory.getName())
                .description(questionBankCategory.getDescription())
                .isOrgQuestionBank(questionBankCategory.getIsOrgQuestionBank())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(questionBankCategory.getCreatedAt())
                .updatedAt(questionBankCategory.getUpdatedAt())
                .build();
    }

    public QuestionBankCategory questionBankCategoryEntityToQuestionBankCategory(QuestionBankCategoryEntity questionBankCategoryEntity) {
        User createdBy = userDataAccessMapper.userEntityToUser(questionBankCategoryEntity.getCreatedBy());
        User updatedBy = userDataAccessMapper.userEntityToUser(questionBankCategoryEntity.getUpdatedBy());
        QuestionBankCategory response = QuestionBankCategory.builder()
                .name(questionBankCategoryEntity.getName())
                .description(questionBankCategoryEntity.getDescription())
                .isOrgQuestionBank(questionBankCategoryEntity.getIsOrgQuestionBank())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(questionBankCategoryEntity.getCreatedAt())
                .updatedAt(questionBankCategoryEntity.getUpdatedAt())
                .build();
        response.setId(new QuestionBankCategoryId(questionBankCategoryEntity.getId()));
        return response;
    }
}
