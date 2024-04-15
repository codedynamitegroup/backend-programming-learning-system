package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.QuestionBankCategoryId;
import com.backend.programming.learning.system.valueobject.QuestionBankEntriesId;
import com.backend.programming.learning.system.valueobject.QuestionId;

public class QuestionBankEntries extends AggregateRoot<QuestionBankEntriesId> {
    private QuestionId questionId;
    private QuestionBankCategoryId questionBankCategoryId;


    private QuestionBankEntries(Builder builder) {
        super.setId(builder.questionBankEntriesId);
        questionId = builder.questionId;
        questionBankCategoryId = builder.questionBankCategoryId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public QuestionId getQuestionId() {
        return questionId;
    }

    public QuestionBankCategoryId getQuestionBankCategoryId() {
        return questionBankCategoryId;
    }

    public static final class Builder {
        private QuestionBankEntriesId questionBankEntriesId;
        private QuestionId questionId;
        private QuestionBankCategoryId questionBankCategoryId;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(QuestionBankEntriesId val) {
            questionBankEntriesId = val;
            return this;
        }

        public Builder questionId(QuestionId val) {
            questionId = val;
            return this;
        }

        public Builder questionBankCategoryId(QuestionBankCategoryId val) {
            questionBankCategoryId = val;
            return this;
        }

        public QuestionBankEntries build() {
            return new QuestionBankEntries(this);
        }
    }
}
