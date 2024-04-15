package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.QuestionBankEntries;

public interface QuestionBankEntriesRepository {
    QuestionBankEntries saveQuestionBankEntries(QuestionBankEntries questionBankEntries);
}
