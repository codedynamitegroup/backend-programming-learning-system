package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.QtypeShortAnswerQuestionId;

import java.util.UUID;

public class QtypeShortAnswerQuestion extends BaseEntity<QtypeShortAnswerQuestionId> {
    private final Question question;
    private final Boolean caseSensitive;

    private QtypeShortAnswerQuestion(Builder builder) {
        super.setId(builder.qtypeShortAnswerQuestionId);
        question = builder.question;
        caseSensitive = builder.caseSensitive;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Question getQuestion() {
        return question;
    }

    public Boolean getCaseSensitive() {
        return caseSensitive;
    }

    public void initQtypeShortAnswerQuestion() {
        setId(new QtypeShortAnswerQuestionId(UUID.randomUUID()));
    }

    public static final class Builder {
        private QtypeShortAnswerQuestionId qtypeShortAnswerQuestionId;
        private Question question;
        private Boolean caseSensitive;

        private Builder() {
        }

        public Builder id(QtypeShortAnswerQuestionId val) {
            qtypeShortAnswerQuestionId = val;
            return this;
        }

        public Builder question(Question val) {
            question = val;
            return this;
        }

        public Builder caseSensitive(Boolean val) {
            caseSensitive = val;
            return this;
        }

        public QtypeShortAnswerQuestion build() {
            return new QtypeShortAnswerQuestion(this);
        }
    }
}
