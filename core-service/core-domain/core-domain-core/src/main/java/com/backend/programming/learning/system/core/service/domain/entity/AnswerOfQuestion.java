package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.AnswerId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;

import java.util.UUID;

public class AnswerOfQuestion extends BaseEntity<AnswerId> {
    private final Question question;
    private final String feedback;
    private final String answer;
    private final float fraction;

    public void initializeAnswerOfQuestion() {
        setId(new AnswerId(UUID.randomUUID()));
    }

    public Question getQuestion() {
        return question;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getAnswer() {
        return answer;
    }

    public float getFraction() {
        return fraction;
    }

    private AnswerOfQuestion(Builder builder) {
        super.setId(builder.answerId);
        question = builder.question;
        feedback = builder.feedback;
        answer = builder.answer;
        fraction = builder.fraction;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private AnswerId answerId;
        private Question question;
        private String feedback;
        private String answer;
        private float fraction;

        private Builder() {
        }

        public Builder id(AnswerId val) {
            answerId = val;
            return this;
        }

        public Builder question(Question val) {
            question = val;
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

        public Builder fraction(float val) {
            fraction = val;
            return this;
        }

        public AnswerOfQuestion build() {
            return new AnswerOfQuestion(this);
        }
    }
}
