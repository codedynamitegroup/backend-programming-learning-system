package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;

public class Question extends AggregateRoot<QuestionId> {
    private final String name;

    public Question(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
