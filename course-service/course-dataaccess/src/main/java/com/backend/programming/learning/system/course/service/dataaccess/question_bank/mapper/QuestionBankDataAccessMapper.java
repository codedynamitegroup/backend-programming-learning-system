package com.backend.programming.learning.system.course.service.dataaccess.question_bank.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question_bank.entity.QuestionBankEntity;
import com.backend.programming.learning.system.entity.Organization;
import com.backend.programming.learning.system.entity.QuestionBank;
import com.backend.programming.learning.system.valueobject.QuestionBankId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionBankDataAccessMapper {
    private final OrganizationDataAccessMapper organizationDataAccessMapper;
    public QuestionBankEntity questionBankToQuestionBankEntity(QuestionBank questionBank) {
        OrganizationEntity organizationEntity = organizationDataAccessMapper.organizationToOrganizationEntity(questionBank.getOrganization());
        return QuestionBankEntity.builder()
                .id(questionBank.getId().getValue())
                .organization(organizationEntity)
                .name(questionBank.getName())
                .build();
    }

    public QuestionBank questionBankEntityToQuestionBank(QuestionBankEntity questionBankEntity) {
        Organization organization = organizationDataAccessMapper.organizationEntityToOrganization(questionBankEntity.getOrganization());
        QuestionBank response =  QuestionBank.builder()
                .organization(organization)
                .name(questionBankEntity.getName())
                .build();
        response.setId(new QuestionBankId(questionBankEntity.getId()));
        return response;
    }
}
