package com.backend.programming.learning.system.implement.question_bank;

import com.backend.programming.learning.system.dto.method.create.question_bank.CreateQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.create.question_bank.CreateQuestionBankResponse;
import com.backend.programming.learning.system.dto.method.query.question_bank.QueryAllQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.query.question_bank.QueryAllQuestionBankResponse;
import com.backend.programming.learning.system.dto.method.query.question_bank.QueryQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.update.question_bank.UpdateQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.update.question_bank.UpdateQuestionBankResponse;
import com.backend.programming.learning.system.dto.responseentity.question_bank.QuestionBankResponseEntity;
import com.backend.programming.learning.system.ports.input.service.question_bank.QuestionBankApplicationService;
import com.backend.programming.learning.system.valueobject.QuestionBankId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * com.backend.programming.learning.system.implement.question_bank
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 3:47 PM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class QuestionBankApplicationServiceImpl implements QuestionBankApplicationService {
    private final QuestionBankCommandHandler questionBankCommandHandler;
    @Override
    public CreateQuestionBankResponse createQuestionBankCommand(CreateQuestionBankCommand createQuestionBankCommand) {
        return questionBankCommandHandler.createQuestionBank(createQuestionBankCommand);
    }

    @Override
    public QueryAllQuestionBankResponse findAllQuestionBank(QueryAllQuestionBankCommand queryAllQuestionBankCommand) {
        return questionBankCommandHandler.findAllQuestionBank(queryAllQuestionBankCommand);
    }

    @Override
    public QuestionBankResponseEntity findQuestionBankById(QueryQuestionBankCommand queryQuestionBankCommand) {
        return questionBankCommandHandler.findQuestionBankById(queryQuestionBankCommand);
    }

    @Override
    public UpdateQuestionBankResponse updateQuestionBankCommand(QuestionBankId questionBankId,
                                                                UpdateQuestionBankCommand createQuestionBankCommand) {
        return questionBankCommandHandler.updateQuestionBank(questionBankId, createQuestionBankCommand);
    }

    @Override
    public void deleteQuestionBank(QuestionBankId questionBankId) {
        questionBankCommandHandler.deleteQuestionBank(questionBankId);
    }
}
