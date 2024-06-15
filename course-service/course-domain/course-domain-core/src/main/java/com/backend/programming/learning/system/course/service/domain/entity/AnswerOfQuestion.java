package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.AnswerOfQuestionId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;

import java.util.UUID;

public class AnswerOfQuestion  extends AggregateRoot<AnswerOfQuestionId> {
    private final QuestionId questionId;
    private String answer;
    private String feedback;
    private Float fraction;

    private AnswerOfQuestion(Builder builder) {
        super.setId(builder.id);
        questionId = builder.questionId;
        answer = builder.answer;
        feedback = builder.feedback;
        fraction = builder.fraction;
    }

    public static Builder builder() {
        return new Builder();
    }

    public QuestionId getQuestionId() {
        return questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public String getFeedback() {
        return feedback;
    }

    public Float getFraction() {
        return fraction;
    }

    public static final class Builder {
        private AnswerOfQuestionId id;
        private QuestionId questionId;
        private String answer;
        private String feedback;
        private Float fraction;

        private Builder() {
        }

        public Builder id(AnswerOfQuestionId val) {
            id = val;
            return this;
        }

        public Builder questionId(QuestionId val) {
            questionId = val;
            return this;
        }

        public Builder answer(String val) {
            answer = val;
            return this;
        }

        public Builder feedback(String val) {
            feedback = val;
            return this;
        }

        public Builder fraction(Float val) {
            fraction = val;
            return this;
        }

        public AnswerOfQuestion build() {
            return new AnswerOfQuestion(this);
        }
    }
}
