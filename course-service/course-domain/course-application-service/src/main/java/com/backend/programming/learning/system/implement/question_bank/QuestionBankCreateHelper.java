package com.backend.programming.learning.system.implement.question_bank;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.dto.method.create.question_bank.CreateQuestionBankCommand;
import com.backend.programming.learning.system.entity.Organization;
import com.backend.programming.learning.system.entity.QuestionBank;
import com.backend.programming.learning.system.mapper.question_bank.QuestionBankDataMapper;
import com.backend.programming.learning.system.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.ports.output.repository.QuestionBankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.implement.question_bank
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 3:49 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionBankCreateHelper {
    private final CourseDomainService courseDomainService;
    private final QuestionBankRepository questionBankRepository;
    private final OrganizationRepository organizationRepository;
    private final QuestionBankDataMapper questionBankDataMapper;
    public QuestionBank createQuestionBank(CreateQuestionBankCommand createQuestionBankCommand) {
        Organization organization = getOrganization(createQuestionBankCommand.getOrganizationId());
        QuestionBank questionBank = questionBankDataMapper.createQuestionBankCommandToQuestionBank(organization, createQuestionBankCommand);
        courseDomainService.createQuestionBank(questionBank);
        return saveQuestionBank(questionBank);
    }

    private QuestionBank saveQuestionBank(QuestionBank questionBank) {
        QuestionBank questionBankResult = questionBankRepository.save(questionBank);
        log.info("QuestionBank is created with id: {}", questionBankResult.getId());
        return questionBankResult;
    }

    private Organization getOrganization(UUID organizationId) {
        Optional<Organization> organization = organizationRepository.findOrganization(organizationId);
        if (organization.isEmpty()) {
            log.warn("Organization with id: {} not found", organizationId);
            throw new RuntimeException("Organization not found");
        }
        return organization.get();
    }
}
