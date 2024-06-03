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
    private Float maxGrade;
    private Float grade;
    private Long doTime;
    private Integer numOfSubmissions;
    private Integer numOfCorrectSubmissions;

    private ContestQuestion(Builder builder) {
        super.setId(builder.contestQuestionId);
        setQuestion(builder.question);
        setContest(builder.contest);
        setCodeQuestionId(builder.codeQuestionId);
        setMaxGrade(builder.maxGrade);
        setGrade(builder.grade);
        setDoTime(builder.doTime);
        setNumOfSubmissions(builder.numOfSubmissions);
        setNumOfCorrectSubmissions(builder.numOfCorrectSubmissions);
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

    public Float getMaxGrade() {
        return maxGrade;
    }

    public void setMaxGrade(Float maxGrade) {
        this.maxGrade = maxGrade;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public Long getDoTime() {
        return doTime;
    }

    public void setDoTime(Long doTime) {
        this.doTime = doTime;
    }

    public Integer getNumOfSubmissions() {
        return numOfSubmissions;
    }

    public void setNumOfSubmissions(Integer numOfSubmissions) {
        this.numOfSubmissions = numOfSubmissions;
    }

    public Integer getNumOfCorrectSubmissions() {
        return numOfCorrectSubmissions;
    }

    public void setNumOfCorrectSubmissions(Integer numOfCorrectSubmissions) {
        this.numOfCorrectSubmissions = numOfCorrectSubmissions;
    }

    public static final class Builder {
        private ContestQuestionId contestQuestionId;
        private Question question;
        private Contest contest;
        private UUID codeQuestionId;
        private Float maxGrade;
        private Float grade;
        private Long doTime;
        private Integer numOfSubmissions;
        private Integer numOfCorrectSubmissions;

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

        public Builder maxGrade(Float val) {
            maxGrade = val;
            return this;
        }

        public Builder grade(Float val) {
            grade = val;
            return this;
        }

        public Builder doTime(Long val) {
            doTime = val;
            return this;
        }

        public Builder numOfSubmissions(Integer val) {
            numOfSubmissions = val;
            return this;
        }

        public Builder numOfCorrectSubmissions(Integer val) {
            numOfCorrectSubmissions = val;
            return this;
        }

        public ContestQuestion build() {
            return new ContestQuestion(this);
        }
    }
}
