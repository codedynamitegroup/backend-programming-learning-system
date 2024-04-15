package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.QuestionBank;

public interface QuestionBankRepository {
    QuestionBank saveQuestionBank(QuestionBank questionBank);
}
