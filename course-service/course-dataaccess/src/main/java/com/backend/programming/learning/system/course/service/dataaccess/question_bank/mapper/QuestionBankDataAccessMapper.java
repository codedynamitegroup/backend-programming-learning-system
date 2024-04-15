package com.backend.programming.learning.system.course.service.dataaccess.question_bank.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.question_bank.entity.QuestionBankEntity;
import com.backend.programming.learning.system.entity.QuestionBank;
import com.backend.programming.learning.system.valueobject.QuestionBankId;
import org.springframework.stereotype.Component;

@Component
public class QuestionBankDataAccessMapper {
    public QuestionBankEntity questionBankToQuestionBankEntity(QuestionBank questionBank) {
        return QuestionBankEntity.builder()
                .id(questionBank.getId().getValue())
                .name(questionBank.getName())
                .build();
    }

    public QuestionBank questionBankEntityToQuestionBank(QuestionBankEntity questionBankEntity) {
        return QuestionBank.builder()
                .id(new QuestionBankId(questionBankEntity.getId()))
                .name(questionBankEntity.getName())
                .build();
    }
}
