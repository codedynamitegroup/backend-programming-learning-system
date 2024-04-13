package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.QuestionBankCategoryId;
import com.backend.programming.learning.system.valueobject.QuestionBankId;

public class QuestionBankCategory extends AggregateRoot<QuestionBankCategoryId> {
    private QuestionBankId questionBankId;
    private String name;

    private QuestionBankCategory(Builder builder) {
        super.setId(builder.questionBankCategoryId);
        questionBankId = builder.questionBankId;
        name = builder.name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public QuestionBankId getQuestionBankId() {
        return questionBankId;
    }

    public String getName() {
        return name;
    }

    public static final class Builder {
        private QuestionBankCategoryId questionBankCategoryId;
        private QuestionBankId questionBankId;
        private String name;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder questionBankCategoryId(QuestionBankCategoryId val) {
            questionBankCategoryId = val;
            return this;
        }

        public Builder questionBankId(QuestionBankId val) {
            questionBankId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public QuestionBankCategory build() {
            return new QuestionBankCategory(this);
        }
    }
}
