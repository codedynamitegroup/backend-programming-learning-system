package com.backend.programming.learning.system.implement.question_bank;

import com.backend.programming.learning.system.dto.method.update.question_bank.UpdateQuestionBankCommand;
import com.backend.programming.learning.system.entity.QuestionBank;
import com.backend.programming.learning.system.ports.output.repository.QuestionBankRepository;
import com.backend.programming.learning.system.valueobject.QuestionBankId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.implement.question_bank
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 3:48 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionBankUpdateHelper {
    private final QuestionBankRepository questionBankRepository;
    public QuestionBank updateQuestionBank(QuestionBankId questionBankId, UpdateQuestionBankCommand updateQuestionBankCommand) {
        QuestionBank questionBank = questionBankRepository.findById(questionBankId.getValue());
        questionBank.setName(updateQuestionBankCommand.name());
        return questionBankRepository.save(questionBank);
    }

}
