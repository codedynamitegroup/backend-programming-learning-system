package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.ExamId;
import com.backend.programming.learning.system.valueobject.ExamQuestionId;
import com.backend.programming.learning.system.valueobject.QuestionId;

public class ExamQuestion extends AggregateRoot<ExamQuestionId> {
    private ExamId examId;
    private QuestionId questionId;

    private ExamQuestion(Builder builder) {
        super.setId(builder.examQuestionId);
        examId = builder.examId;
        questionId = builder.questionId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ExamId getExamId() {
        return examId;
    }

    public QuestionId getQuestionId() {
        return questionId;
    }

    public static final class Builder {
        private ExamQuestionId examQuestionId;
        private ExamId examId;
        private QuestionId questionId;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder examQuestion(ExamQuestionId val) {
            examQuestionId = val;
            return this;
        }

        public Builder examId(ExamId val) {
            examId = val;
            return this;
        }

        public Builder questionId(QuestionId val) {
            questionId = val;
            return this;
        }

        public ExamQuestion build() {
            return new ExamQuestion(this);
        }
    }
}
