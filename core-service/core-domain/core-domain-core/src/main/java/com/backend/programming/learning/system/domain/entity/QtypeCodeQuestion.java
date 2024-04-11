package com.backend.programming.learning.system.domain.entity;

import com.backend.programming.learning.system.domain.valueobject.QtypeCodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;

public class QtypeCodeQuestion extends BaseEntity<QtypeCodeQuestionId>{
    private final QuestionId questionId;
    private final String dslTemplate;

    private QtypeCodeQuestion(Builder builder) {
        super.setId(builder.qtypeCodeQuestionId);
        questionId = builder.questionId;
        dslTemplate = builder.dslTemplate;
    }

    public QuestionId getQuestionId() {
        return questionId;
    }

    public String getDslTemplate() {
        return dslTemplate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private QtypeCodeQuestionId qtypeCodeQuestionId;
        private QuestionId questionId;
        private String dslTemplate;

        private Builder() {
        }

        public Builder id(QtypeCodeQuestionId val) {
            qtypeCodeQuestionId = val;
            return this;
        }

        public Builder questionId(QuestionId val) {
            questionId = val;
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
