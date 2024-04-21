package com.backend.programming.learning.system.implement.question_bank;

import com.backend.programming.learning.system.dto.method.create.question_bank.CreateQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.create.question_bank.CreateQuestionBankResponse;
import com.backend.programming.learning.system.dto.method.query.question_bank.QueryAllQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.query.question_bank.QueryAllQuestionBankResponse;
import com.backend.programming.learning.system.dto.method.query.question_bank.QueryQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.update.question_bank.UpdateQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.update.question_bank.UpdateQuestionBankResponse;
import com.backend.programming.learning.system.dto.responseentity.question_bank.QuestionBankResponseEntity;
import com.backend.programming.learning.system.entity.QuestionBank;
import com.backend.programming.learning.system.mapper.question_bank.QuestionBankDataMapper;
import com.backend.programming.learning.system.valueobject.QuestionBankId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.backend.programming.learning.system.implement.question_bank
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 3:47 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionBankCommandHandler {
    private final QuestionBankCreateHelper questionBankCreateHelper;
    private final QuestionBankQueryHelper questionBankQueryHelper;
    private final QuestionBankUpdateHelper questionBankUpdateHelper;
    private final QuestionBankDeleteHelper questionBankDeleteHelper;
    private final QuestionBankDataMapper questionBankDataMapper;
    @Transactional
    public CreateQuestionBankResponse createQuestionBank(CreateQuestionBankCommand createQuestionBankCommand) {
        QuestionBank questionBank = questionBankCreateHelper.createQuestionBank(createQuestionBankCommand);
        log.info("Question bank created successfully");
        return questionBankDataMapper.questionBankToCreateQuestionBankResponse(questionBank);
    }

    @Transactional(readOnly = true)
    public QueryAllQuestionBankResponse findAllQuestionBank(QueryAllQuestionBankCommand queryAllQuestionBankCommand) {
        Page<QuestionBank> questionBanks = questionBankQueryHelper.findAll(queryAllQuestionBankCommand);
        log.info("Found {} question banks", questionBanks.getTotalElements());
        return questionBankDataMapper.questionBankPageToQueryAllQuestionBankResponse(questionBanks);
    }

    @Transactional(readOnly = true)
    public QuestionBankResponseEntity findQuestionBankById(QueryQuestionBankCommand queryQuestionBankCommand) {
        QuestionBank questionBank = questionBankQueryHelper.findById(queryQuestionBankCommand);
        log.info("Found question bank by id");
        return questionBankDataMapper.questionBankToQuestionBankResponseEntity(questionBank);
    }

    @Transactional
    public UpdateQuestionBankResponse updateQuestionBank(QuestionBankId questionBankId, UpdateQuestionBankCommand createQuestionBankCommand) {
        QuestionBank questionBank = questionBankUpdateHelper.updateQuestionBank(questionBankId, createQuestionBankCommand);
        log.info("Question bank updated successfully");
        return questionBankDataMapper.questionBankToUpdateQuestionBankResponse(questionBank);
    }

    public void deleteQuestionBank(QuestionBankId questionBankId) {
        questionBankDeleteHelper.deleteQuestionBank(questionBankId);
        log.info("Question bank deleted successfully");
    }
}
