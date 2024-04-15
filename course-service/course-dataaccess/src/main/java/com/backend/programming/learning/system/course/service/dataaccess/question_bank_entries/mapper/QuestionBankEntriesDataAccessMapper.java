package com.backend.programming.learning.system.course.service.dataaccess.question_bank_entries.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.question_bank_entries.entity.QuestionBankEntriesEntity;
import com.backend.programming.learning.system.entity.QuestionBankEntries;
import com.backend.programming.learning.system.valueobject.QuestionBankEntriesId;
import org.springframework.stereotype.Component;

@Component
public class QuestionBankEntriesDataAccessMapper {
    public QuestionBankEntriesEntity questionBankEntriesToQuestionBankEntriesEntity(QuestionBankEntries questionBankEntries) {
        return QuestionBankEntriesEntity.builder()
                .id(questionBankEntries.getId().getValue())
                .build();
    }

    public QuestionBankEntries questionBankEntriesEntityToQuestionBankEntries(QuestionBankEntriesEntity questionBankEntriesEntity) {
        return QuestionBankEntries.builder()
                .id(new QuestionBankEntriesId(questionBankEntriesEntity.getId()))
                .build();
    }
}
