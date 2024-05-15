package com.backend.programming.learning.system.core.service.domain.dto.responseentity.question;

public class QtypeMultichoiceQuestionResponseEntity {
    private final QuestionResponseEntity question;
    private final String id;
    private final Boolean single;
    private final Boolean shuffleAnswers;
    private final String correctFeedback;
    private final String partiallyCorrectFeedback;
    private final String incorrectFeedback;
    private final String answerNumbering;
    private final Integer showNumCorrect;
    private final String showStandardInstructions;

    private QtypeMultichoiceQuestionResponseEntity(Builder builder) {
        question = builder.question;
        id = builder.id;
        single = builder.single;
        shuffleAnswers = builder.shuffleAnswers;
        correctFeedback = builder.correctFeedback;
        partiallyCorrectFeedback = builder.partiallyCorrectFeedback;
        incorrectFeedback = builder.incorrectFeedback;
        answerNumbering = builder.answerNumbering;
        showNumCorrect = builder.showNumCorrect;
        showStandardInstructions = builder.showStandardInstructions;
    }

    public QuestionResponseEntity getQuestion() {
        return question;
    }

    public String getId() {
        return id;
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

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private QuestionResponseEntity question;
        private String id;
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

        public Builder question(QuestionResponseEntity val) {
            question = val;
            return this;
        }

        public Builder id(String val) {
            id = val;
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

        public QtypeMultichoiceQuestionResponseEntity build() {
            return new QtypeMultichoiceQuestionResponseEntity(this);
        }
    }
}
