package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.QtypeMultiChoiceQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;

import java.util.UUID;

public class QtypeMultiChoiceQuestion extends BaseEntity<QtypeMultiChoiceQuestionId> {
    private final QuestionId questionId;
    private final Boolean single;
    private final Boolean shuffleAnswers;
    private final String correctFeedback;
    private final String partiallyCorrectFeedback;
    private final String incorrectFeedback;
    private final String answerNumbering;
    private final Integer showNumCorrect;
    private final String showStandardInstructions;

    // Getter Methods
    public QuestionId getQuestionId() {
        return questionId;
    }

    public Boolean getSingle() {
        return single;
    }

    public Boolean getShuffleAnswers() {
        return shuffleAnswers;
    }

    public String getCorrectFeedback() {
        return correctFeedback;
    }

    public String getPartiallyCorrectFeedback() {
        return partiallyCorrectFeedback;
    }

    public String getIncorrectFeedback() {
        return incorrectFeedback;
    }

    public String getAnswerNumbering() {
        return answerNumbering;
    }

    public Integer getShowNumCorrect() {
        return showNumCorrect;
    }

    public String getShowStandardInstructions() {
        return showStandardInstructions;
    }

    // Builder
    private QtypeMultiChoiceQuestion(Builder builder) {
        super.setId(builder.qtypeMultiChoiceQuestionId);
        questionId = builder.questionId;
        single = builder.single;
        shuffleAnswers = builder.shuffleAnswers;
        correctFeedback = builder.correctFeedback;
        partiallyCorrectFeedback = builder.partiallyCorrectFeedback;
        incorrectFeedback = builder.incorrectFeedback;
        answerNumbering = builder.answerNumbering;
        showNumCorrect = builder.showNumCorrect;
        showStandardInstructions = builder.showStandardInstructions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void initQtypeMultipleChoiceQuestion() {
        setId(new QtypeMultiChoiceQuestionId(UUID.randomUUID()));
    }

    public static final class Builder {
        private QtypeMultiChoiceQuestionId qtypeMultiChoiceQuestionId;
        private QuestionId questionId;
        private Boolean single;
        private Boolean shuffleAnswers;
        private String correctFeedback;
        private String partiallyCorrectFeedback;
        private String incorrectFeedback;
        private String answerNumbering;
        private Integer showNumCorrect;
        private String showStandardInstructions;

        private Builder() {
        }

        public Builder id(QtypeMultiChoiceQuestionId val) {
            qtypeMultiChoiceQuestionId = val;
            return this;
        }

        public Builder questionId(QuestionId val) {
            questionId = val;
            return this;
        }

        public Builder single(Boolean val) {
            single = val;
            return this;
        }

        public Builder shuffleAnswers(Boolean val) {
            shuffleAnswers = val;
            return this;
        }

        public Builder correctFeedback(String val) {
            correctFeedback = val;
            return this;
        }

        public Builder partiallyCorrectFeedback(String val) {
            partiallyCorrectFeedback = val;
            return this;
        }

        public Builder incorrectFeedback(String val) {
            incorrectFeedback = val;
            return this;
        }

        public Builder answerNumbering(String val) {
            answerNumbering = val;
            return this;
        }

        public Builder showNumCorrect(Integer val) {
            showNumCorrect = val;
            return this;
        }

        public Builder showStandardInstructions(String val) {
            showStandardInstructions = val;
            return this;
        }

        public QtypeMultiChoiceQuestion build() {
            return new QtypeMultiChoiceQuestion(this);
        }
    }
}
