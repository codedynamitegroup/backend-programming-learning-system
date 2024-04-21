package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.QuestionBankId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class QuestionBank extends AggregateRoot<QuestionBankId> {
    private Organization organization;
    private String name;
    public void initializeQuestionBank() {
        setId(new QuestionBankId(UUID.randomUUID()));
    }
}
