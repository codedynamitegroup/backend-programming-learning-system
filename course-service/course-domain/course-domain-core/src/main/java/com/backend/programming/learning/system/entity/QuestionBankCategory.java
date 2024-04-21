package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.QuestionBankCategoryId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class QuestionBankCategory extends AggregateRoot<QuestionBankCategoryId> {
    private QuestionBank questionBank;
    private String name;

    public void initializeQuestionBankCategory() {
        this.setId(new QuestionBankCategoryId(UUID.randomUUID()));
    }
}
