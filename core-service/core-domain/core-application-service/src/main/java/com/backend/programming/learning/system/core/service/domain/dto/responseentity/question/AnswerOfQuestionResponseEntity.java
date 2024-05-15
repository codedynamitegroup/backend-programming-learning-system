package com.backend.programming.learning.system.core.service.domain.dto.responseentity.question;

public class AnswerOfQuestionResponseEntity {
    private final String id;
    private final String questionId;
    private final String feedback;
    private final String answer;
    private final Float fraction;

    public String getId() {
        return id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getAnswer() {
        return answer;
    }

    public Float getFraction() {
        return fraction;
    }

    private AnswerOfQuestionResponseEntity(Builder builder) {
        id = builder.id;
        questionId = builder.questionId;
        feedback = builder.feedback;
        answer = builder.answer;
        fraction = builder.fraction;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String questionId;
        private String feedback;
        private String answer;
        private Float fraction;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder questionId(String val) {
            questionId = val;
            return this;
        }

        public Builder feedback(String val) {
            feedback = val;
            return this;
        }

        public Builder answer(String val) {
            answer = val;
            return this;
        }

        public Builder fraction(Float val) {
            fraction = val;
            return this;
        }

        public AnswerOfQuestionResponseEntity build() {
            return new AnswerOfQuestionResponseEntity(this);
        }
    }
}
