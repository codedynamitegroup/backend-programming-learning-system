package com.backend.programming.learning.system.ports.input.service.question_bank;

import com.backend.programming.learning.system.dto.method.create.question_bank.CreateQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.create.question_bank.CreateQuestionBankResponse;
import com.backend.programming.learning.system.dto.method.query.question_bank.QueryAllQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.query.question_bank.QueryAllQuestionBankResponse;
import com.backend.programming.learning.system.dto.method.query.question_bank.QueryQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.update.question_bank.UpdateQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.update.question_bank.UpdateQuestionBankResponse;
import com.backend.programming.learning.system.dto.responseentity.question_bank.QuestionBankResponseEntity;
import com.backend.programming.learning.system.valueobject.QuestionBankId;

import javax.validation.Valid;

/**
 * com.backend.programming.learning.system.ports.input.service.question_bank
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 3:47 PM
 * Description: ...
 */
public interface QuestionBankApplicationService {
    CreateQuestionBankResponse createQuestionBankCommand(
            @Valid CreateQuestionBankCommand createQuestionBankCommand);

    QueryAllQuestionBankResponse findAllQuestionBank(
            @Valid QueryAllQuestionBankCommand queryAllQuestionBankCommand);

    QuestionBankResponseEntity findQuestionBankById(
            @Valid QueryQuestionBankCommand queryQuestionBankCommand);

    UpdateQuestionBankResponse updateQuestionBankCommand(
            QuestionBankId questionBankId,
            @Valid UpdateQuestionBankCommand createQuestionBankCommand);

    void deleteQuestionBank(QuestionBankId questionBankId);
}
