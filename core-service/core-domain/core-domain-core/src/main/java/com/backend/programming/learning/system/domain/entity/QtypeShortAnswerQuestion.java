package com.backend.programming.learning.system.domain.entity;

import com.backend.programming.learning.system.domain.valueobject.QtypeShortAnswerQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;

public class QtypeShortAnswerQuestion extends BaseEntity<QtypeShortAnswerQuestionId> {
    private final QuestionId questionId;
    private final boolean caseSensitive;

    private QtypeShortAnswerQuestion(Builder builder) {
        super.setId(builder.qtypeShortAnswerQuestionId);
        questionId = builder.questionId;
        caseSensitive = builder.caseSensitive;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private QtypeShortAnswerQuestionId qtypeShortAnswerQuestionId;
        private QuestionId questionId;
        private boolean caseSensitive;

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

        public Builder caseSensitive(boolean val) {
            caseSensitive = val;
            return this;
        }

        public QtypeShortAnswerQuestion build() {
            return new QtypeShortAnswerQuestion(this);
        }
    }
}
