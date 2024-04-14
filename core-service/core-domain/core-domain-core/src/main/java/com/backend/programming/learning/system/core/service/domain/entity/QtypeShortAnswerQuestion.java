package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.QtypeShortAnswerQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;

import java.util.UUID;

public class QtypeShortAnswerQuestion extends BaseEntity<QtypeShortAnswerQuestionId> {
    private final QuestionId questionId;
    private final Boolean caseSensitive;

    private QtypeShortAnswerQuestion(Builder builder) {
        super.setId(builder.qtypeShortAnswerQuestionId);
        questionId = builder.questionId;
        caseSensitive = builder.caseSensitive;
    }

    public static Builder builder() {
        return new Builder();
    }

    public QuestionId getQuestionId() {
        return questionId;
    }

    public Boolean getCaseSensitive() {
        return caseSensitive;
    }

    public void initQtypeShortAnswerQuestion() {
        setId(new QtypeShortAnswerQuestionId(UUID.randomUUID()));
    }

    public static final class Builder {
        private QtypeShortAnswerQuestionId qtypeShortAnswerQuestionId;
        private QuestionId questionId;
        private Boolean caseSensitive;

        private Builder() {
        }

        public Builder id(QtypeShortAnswerQuestionId val) {
            qtypeShortAnswerQuestionId = val;
            return this;
        }

        public Builder questionId(QuestionId val) {
            questionId = val;
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
