package com.backend.programming.learning.system.core.service.domain.dto.responseentity.question;

public class QtypeShortanswerQuestionResponseEntity {
    private final QuestionResponseEntity question;
    private final String id;
    private final Boolean caseSensitive;

    public QuestionResponseEntity getQuestion() {
        return question;
    }

    public String getId() {
        return id;
    }

    public Boolean getCaseSensitive() {
        return caseSensitive;
    }

    private QtypeShortanswerQuestionResponseEntity(Builder builder) {
        question = builder.question;
        id = builder.id;
        caseSensitive = builder.caseSensitive;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private QuestionResponseEntity question;
        private String id;
        private Boolean caseSensitive;

        private Builder() {
        }

        public Builder question(QuestionResponseEntity val) {
            question = val;
            return this;
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder caseSensitive(Boolean val) {
            caseSensitive = val;
            return this;
        }

        public QtypeShortanswerQuestionResponseEntity build() {
            return new QtypeShortanswerQuestionResponseEntity(this);
        }
    }
}
