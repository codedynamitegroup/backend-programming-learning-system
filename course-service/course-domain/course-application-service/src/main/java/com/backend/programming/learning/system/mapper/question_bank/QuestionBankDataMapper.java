package com.backend.programming.learning.system.mapper.question_bank;

import com.backend.programming.learning.system.dto.method.create.question_bank.CreateQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.create.question_bank.CreateQuestionBankResponse;
import com.backend.programming.learning.system.dto.method.query.question_bank.QueryAllQuestionBankResponse;
import com.backend.programming.learning.system.dto.method.update.question_bank.UpdateQuestionBankResponse;
import com.backend.programming.learning.system.dto.responseentity.question_bank.QuestionBankResponseEntity;
import com.backend.programming.learning.system.entity.Organization;
import com.backend.programming.learning.system.entity.QuestionBank;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.mapper.question_bank
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 3:59 PM
 * Description: ...
 */
@Component
public class QuestionBankDataMapper {
    public QuestionBank createQuestionBankCommandToQuestionBank(Organization organization, CreateQuestionBankCommand createQuestionBankCommand) {
        return QuestionBank.builder()
                .organization(organization)
                .name(createQuestionBankCommand.getName())
                .build();
    }

    public CreateQuestionBankResponse questionBankToCreateQuestionBankResponse(QuestionBank questionBank) {
        return CreateQuestionBankResponse.builder()
                .questionBankId(questionBank.getId().getValue())
                .organizationId(questionBank.getOrganization().getId().getValue())
                .name(questionBank.getName())
                .message("Question bank created successfully")
                .build();
    }

    public QueryAllQuestionBankResponse questionBankPageToQueryAllQuestionBankResponse(Page<QuestionBank> questionBanks) {
        return QueryAllQuestionBankResponse.builder()
                .questionBanks(questionBanks.map(this::questionBankToQuestionBankResponseEntity).getContent())
                .currentPage(questionBanks.getNumber())
                .totalItems(questionBanks.getTotalElements())
                .totalPages(questionBanks.getTotalPages())
                .build();
    }
    public QuestionBankResponseEntity questionBankToQuestionBankResponseEntity(QuestionBank questionBank) {
        return QuestionBankResponseEntity.builder()
                .questionBankId(questionBank.getId().getValue())
                .organizationId(questionBank.getOrganization().getId().getValue())
                .name(questionBank.getName())
                .build();
    }

    public UpdateQuestionBankResponse questionBankToUpdateQuestionBankResponse(QuestionBank questionBank) {
        return UpdateQuestionBankResponse.builder()
                .questionBankId(questionBank.getId().getValue())
                .organizationId(questionBank.getOrganization().getId().getValue())
                .name(questionBank.getName())
                .message("Question bank updated successfully")
                .build();
    }
}
