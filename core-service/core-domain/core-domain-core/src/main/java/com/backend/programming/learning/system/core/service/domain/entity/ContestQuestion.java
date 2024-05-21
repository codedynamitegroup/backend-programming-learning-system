package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterQuestionId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestQuestionId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;

import java.util.List;
import java.util.UUID;

public class ContestQuestion extends BaseEntity<ContestQuestionId> {
    private Question question;
    private Contest contest;
    private UUID codeQuestionId;
    private List<CodeSubmission> codeSubmissions;

    private ContestQuestion(Builder builder) {
        super.setId(builder.contestQuestionId);
        setQuestion(builder.question);
        setContest(builder.contest);
        setCodeQuestionId(builder.codeQuestionId);
        setCodeSubmissions(builder.codeSubmissions);
    }

    public static Builder builder() {
        return new Builder();
    }


    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public UUID getCodeQuestionId() {
        return codeQuestionId;
    }

    public void setCodeQuestionId(UUID codeQuestionId) {
        this.codeQuestionId = codeQuestionId;
    }

    public List<CodeSubmission> getCodeSubmissions() {
        return codeSubmissions;
    }

    public void setCodeSubmissions(List<CodeSubmission> codeSubmissions) {
        this.codeSubmissions = codeSubmissions;
    }

    public static final class Builder {
        private ContestQuestionId contestQuestionId;
        private Question question;
        private Contest contest;
        private UUID codeQuestionId;
        private List<CodeSubmission> codeSubmissions;

        private Builder() {
        }

        public Builder id(ContestQuestionId val) {
            contestQuestionId = val;
            return this;
        }

        public Builder question(Question val) {
            question = val;
            return this;
        }

        public Builder contest(Contest val) {
            contest = val;
            return this;
        }

        public Builder codeQuestionId(UUID val) {
            codeQuestionId = val;
            return this;
        }

        public Builder codeSubmissions(List<CodeSubmission> val) {
            codeSubmissions = val;
            return this;
        }

        public ContestQuestion build() {
            return new ContestQuestion(this);
        }
    }
}
