package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.QtypeCodeQuestionId;

import java.util.UUID;

public class QtypeCodeQuestion extends BaseEntity<QtypeCodeQuestionId> {
    private final Question question;
    private final String dslTemplate;

    public void initQtypeCodeQuestion() {
        setId(new QtypeCodeQuestionId(UUID.randomUUID()));
    }
    private QtypeCodeQuestion(Builder builder) {
        super.setId(builder.qtypeCodeQuestionId);
        question = builder.question;
        dslTemplate = builder.dslTemplate;
    }

    public Question getQuestion() {
        return question;
    }

    public String getDslTemplate() {
        return dslTemplate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private QtypeCodeQuestionId qtypeCodeQuestionId;
        private Question question;
        private String dslTemplate;

        private Builder() {
        }

        public Builder id(QtypeCodeQuestionId val) {
            qtypeCodeQuestionId = val;
            return this;
        }

        public Builder question(Question val) {
            question = val;
            return this;
        }

        public Builder dslTemplate(String val) {
            dslTemplate = val;
            return this;
        }

        public QtypeCodeQuestion build() {
            return new QtypeCodeQuestion(this);
        }
    }
}
