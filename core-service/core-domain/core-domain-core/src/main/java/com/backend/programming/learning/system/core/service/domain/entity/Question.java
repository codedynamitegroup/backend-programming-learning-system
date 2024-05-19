package com.backend.programming.learning.system.core.service.domain.entity;


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
    private Boolean pass;
    private final User createdBy;
    private User updatedBy;
    private final QuestionType qtype;
    private List<String> failureMessages;
    private List<AnswerOfQuestion> answers;
    private CopyState copyState;

    private final ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private Question(Builder builder) {
        super.setId(builder.questionId);
        copyState = builder.copyState;
        organization = builder.organization;
        difficulty = builder.difficulty;
        name = builder.name;
        questionText = builder.questionText;
        generalFeedback = builder.generalFeedback;
        defaultMark = builder.defaultMark;
        pass = builder.pass;
        createdBy = builder.createdBy;
        updatedBy = builder.updatedBy;
        qtype = builder.qtype;
        failureMessages = builder.failureMessages;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        answers = builder.answers;
    }

    public static Builder builder() {
        return new Builder();
    }

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

    public List<AnswerOfQuestion> getAnswers() {
        return answers;
    }

    public CopyState getCopyState() {
        return copyState;
    }

    public void setCopyState(CopyState copyState) {
        this.copyState = copyState;
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

    public User getCreatedBy() {
        return createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public QuestionType getqtype() {
        return qtype;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Boolean getPass() {
        return pass;
    }

    public void setPass(Boolean pass) {
        this.pass = pass;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public static final class Builder {
        private QuestionId questionId;
        private Organization organization;
        private QuestionDifficulty difficulty;
        private String name;
        private String questionText;
        private String generalFeedback;
        private Float defaultMark;
        private Boolean pass;
        private User createdBy;
        private User updatedBy;
        private QuestionType qtype;
        private List<String> failureMessages;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private List<AnswerOfQuestion> answers;
        private CopyState copyState;

        private Builder() {
        }

        public Builder copyState(CopyState val) {
            copyState = val;
            return this;
        }

        public Builder answers(List<AnswerOfQuestion> val) {
            answers = val;
            return this;
        }

        public Builder questionId(QuestionId val) {
            questionId = val;
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

        public Builder pass(Boolean val) {
            pass = val;
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

        public Builder qtype(QuestionType val) {
            qtype = val;
            return this;
        }

        public Builder failureMessages(List<String> val) {
            failureMessages = val;
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
