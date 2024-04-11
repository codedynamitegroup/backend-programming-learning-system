package com.backend.programming.learning.system.domain.entity;


import com.backend.programming.learning.system.domain.valueobject.*;

import java.util.List;
import java.util.UUID;

public class Question extends AggregateRoot<QuestionId> {
    private final OrganizationId organizationId;
    private QuestionDifficulty difficulty;
    private String name;
    private String questionText;
    private String generalFeedback;
    private float defaultMark;
    private final UserId createdBy;
    private UserId updatedBy;
    private final QuestionType qType;
    private List<String> failureMessages;

    public void initializeQuestion() {
        setId(new QuestionId(UUID.randomUUID()));
    }

    private void updateFailureMessages(List<String> failureMessages) {
        if(this.failureMessages != null && failureMessages != null) {
            this.failureMessages.addAll(failureMessages
                    .stream()
                    .filter(failureMessage -> !this.failureMessages
                            .contains(failureMessage))
                    .toList());
        }
        if(this.failureMessages == null) {
            this.failureMessages = failureMessages;
        }
    }

    public OrganizationId getOrganizationId() {
        return organizationId;
    }

    public QuestionDifficulty getDifficulty() {
        return difficulty;
    }

    public String getName() {
        return name;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getGeneralFeedback() {
        return generalFeedback;
    }

    public float getDefaultMark() {
        return defaultMark;
    }

    public UserId getCreatedBy() {
        return createdBy;
    }

    public UserId getUpdatedBy() {
        return updatedBy;
    }

    public QuestionType getqType() {
        return qType;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }

    public static Builder builder() {
        return new Builder();
    }

    private Question(Builder builder) {
        super.setId(builder.questionId);
        organizationId = builder.organizationId;
        difficulty = builder.difficulty;
        name = builder.name;
        questionText = builder.questionText;
        generalFeedback = builder.generalFeedback;
        defaultMark = builder.defaultMark;
        createdBy = builder.createdBy;
        updatedBy = builder.updatedBy;
        qType = builder.qType;
        failureMessages = builder.failureMessages;
    }

    public static final class Builder {
        private QuestionId questionId;
        private OrganizationId organizationId;
        private QuestionDifficulty difficulty;
        private String name;
        private String questionText;
        private String generalFeedback;
        private float defaultMark;
        private UserId createdBy;
        private UserId updatedBy;
        private QuestionType qType;
        private List<String> failureMessages;

        private Builder() {
        }

        public Builder questionId(QuestionId val) {
            questionId = val;
            return this;
        }

        public Builder organizationId(OrganizationId val) {
            organizationId = val;
            return this;
        }

        public Builder difficulty(QuestionDifficulty val) {
            difficulty = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder questionText(String val) {
            questionText = val;
            return this;
        }

        public Builder generalFeedback(String val) {
            generalFeedback = val;
            return this;
        }

        public Builder defaultMark(float val) {
            defaultMark = val;
            return this;
        }

        public Builder createdBy(UserId val) {
            createdBy = val;
            return this;
        }

        public Builder updatedBy(UserId val) {
            updatedBy = val;
            return this;
        }

        public Builder failureMessages(List<String> val) {
            failureMessages = val;
            return this;
        }

        public Builder qType(QuestionType val) {
            qType = val;
            return this;
        }

        public Question build() {
            return new Question(this);
        }
    }
}
