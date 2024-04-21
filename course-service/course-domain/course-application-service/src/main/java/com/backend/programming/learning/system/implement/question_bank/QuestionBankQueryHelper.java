package com.backend.programming.learning.system.implement.question_bank;

import com.backend.programming.learning.system.dto.method.query.question_bank.QueryAllQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.query.question_bank.QueryQuestionBankCommand;
import com.backend.programming.learning.system.entity.QuestionBank;
import com.backend.programming.learning.system.ports.output.repository.QuestionBankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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
public class QuestionBankQueryHelper {
    private final QuestionBankRepository questionBankRepository;

    public Page<QuestionBank> findAll(QueryAllQuestionBankCommand queryAllQuestionBankCommand) {
        return questionBankRepository.findAll(
                queryAllQuestionBankCommand.getSearch(),
                queryAllQuestionBankCommand.getPageNo(),
                queryAllQuestionBankCommand.getPageSize());
    }

    public QuestionBank findById(QueryQuestionBankCommand queryQuestionBankCommand) {
        return questionBankRepository.findById(queryQuestionBankCommand.getQuestionBankId());
    }
}
