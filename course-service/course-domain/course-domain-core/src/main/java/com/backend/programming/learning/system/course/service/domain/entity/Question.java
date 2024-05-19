package com.backend.programming.learning.system.course.service.domain.entity;


import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class Question extends AggregateRoot<QuestionId> {
    private Organization organization;
    private QuestionDifficulty difficulty;
    private String name;
    private String questionText;
    private String generalFeedback;
    private Float defaultMark;
    private QuestionType qtype;
    private List<String> failureMessages;
    private Boolean isQuestionBank;
    private QuestionBankCategory questionBankCategory;

    private User createdBy;
    private User updatedBy;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private Question(Builder builder) {
        super.setId(builder.id);
        organization = builder.organization;
        difficulty = builder.difficulty;
        name = builder.name;
        questionText = builder.questionText;
        generalFeedback = builder.generalFeedback;
        defaultMark = builder.defaultMark;
        qtype = builder.qtype;
        failureMessages = builder.failureMessages;
        isQuestionBank = builder.isQuestionBank;
        questionBankCategory = builder.questionBankCategory;
        createdBy = builder.createdBy;
        updatedBy = builder.updatedBy;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void initializeQuestion() {
        setId(new QuestionId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now();
        updatedAt = ZonedDateTime.now();
    }

    public Organization getOrganization() {
        return organization;
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

    public Float getDefaultMark() {
        return defaultMark;
    }

    public QuestionType getQtype() {
        return qtype;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }

    public Boolean getQuestionBank() {
        return isQuestionBank;
    }

    public QuestionBankCategory getQuestionBankCategory() {
        return questionBankCategory;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }


    public static final class Builder {
        private QuestionId id;
        private Organization organization;
        private QuestionDifficulty difficulty;
        private String name;
        private String questionText;
        private String generalFeedback;
        private Float defaultMark;
        private QuestionType qtype;
        private List<String> failureMessages;
        private Boolean isQuestionBank;
        private QuestionBankCategory questionBankCategory;
        private List<String> answers;
        private User createdBy;
        private User updatedBy;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;

        private Builder() {
        }

        public Builder id(QuestionId val) {
            id = val;
            return this;
        }

        public Builder organization(Organization val) {
            organization = val;
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

        public Builder defaultMark(Float val) {
            defaultMark = val;
            return this;
        }

        public Builder qtype(QuestionType val) {
            qtype = val;
            return this;
        }

        public Builder failureMessages(List<String> val) {
            failureMessages = val;
            return this;
        }

        public Builder isQuestionBank(Boolean val) {
            isQuestionBank = val;
            return this;
        }

        public Builder questionBankCategory(QuestionBankCategory val) {
            questionBankCategory = val;
            return this;
        }

        public Builder answers(List<String> val) {
            answers = val;
            return this;
        }

        public Builder createdBy(User val) {
            createdBy = val;
            return this;
        }

        public Builder updatedBy(User val) {
            updatedBy = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedAt(ZonedDateTime val) {
            updatedAt = val;
            return this;
        }

        public Question build() {
            return new Question(this);
        }
    }
}
