package com.backend.programming.learning.system.implement.question_bank;

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
public class QuestionBankDeleteHelper {
    private final QuestionBankRepository questionBankRepository;
    public void deleteQuestionBank(QuestionBankId questionBankId) {
        questionBankRepository.deleteById(questionBankId.getValue());
    }
}
