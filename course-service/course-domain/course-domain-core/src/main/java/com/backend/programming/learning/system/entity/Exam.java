package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.ExamId;
import com.backend.programming.learning.system.valueobject.OverdueHandling;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Exam extends AggregateRoot<ExamId> {
    private Course course;
    private String name;
    private Float score;
    private Float maxScore;

    private ZonedDateTime timeOpen;
    private ZonedDateTime timeClose;
    private Integer timeLimit;

    private String intro;
    private OverdueHandling overdueHandling;
    private Boolean canRedoQuestions;
    private Integer maxAttempts;

    private Boolean shuffleAnswers;
    private String gradeMethod;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;



    private Exam(Builder builder) {
        super.setId(builder.examId);;
        course = builder.course;
        name = builder.name;
        score = builder.score;
        maxScore = builder.maxScore;
        timeOpen = builder.timeOpen;
        timeClose = builder.timeClose;
        timeLimit = builder.timeLimit;
        intro = builder.intro;
        overdueHandling = builder.overdueHandling;
        canRedoQuestions = builder.canRedoQuestions;
        maxAttempts = builder.maxAttempts;
        shuffleAnswers = builder.shuffleAnswers;
        gradeMethod = builder.gradeMethod;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }
    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public Float getScore() {
        return score;
    }

    public Float getMaxScore() {
        return maxScore;
    }

    public ZonedDateTime getTimeOpen() {
        return timeOpen;
    }

    public ZonedDateTime getTimeClose() {
        return timeClose;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public String getIntro() {
        return intro;
    }

    public OverdueHandling getOverdueHanding() {
        return overdueHandling;
    }

    public Boolean getCanRedoQuestions() {
        return canRedoQuestions;
    }

    public Integer getMaxAttempts() {
        return maxAttempts;
    }

    public Boolean getShuffleAnswers() {
        return shuffleAnswers;
    }

    public String getGradeMethod() {
        return gradeMethod;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void initializeExam(Course course, ExamId examId) {
        this.course = course;
        this.setId(examId);
    }

    public void initializeExam() {
        setId(new ExamId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
        updatedAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public void setMaxScore(Float maxScore) {
        this.maxScore = maxScore;
    }

    public void setTimeOpen(ZonedDateTime timeOpen) {
        this.timeOpen = timeOpen;
    }

    public void setTimeClose(ZonedDateTime timeClose) {
        this.timeClose = timeClose;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setOverdueHanding(OverdueHandling overdueHanding) {
        this.overdueHandling = overdueHanding;
    }

    public void setCanRedoQuestions(Boolean canRedoQuestions) {
        this.canRedoQuestions = canRedoQuestions;
    }

    public void setMaxAttempts(Integer maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public void setShuffleAnswers(Boolean shuffleAnswers) {
        this.shuffleAnswers = shuffleAnswers;
    }

    public void setGradeMethod(String gradeMethod) {
        this.gradeMethod = gradeMethod;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static final class Builder {
        private ExamId examId;
        private Course course;
        private String name;
        private Float score;
        private Float maxScore;
        private ZonedDateTime timeOpen;
        private ZonedDateTime timeClose;
        private Integer timeLimit;
        private String intro;
        private OverdueHandling overdueHandling;
        private Boolean canRedoQuestions;
        private Integer maxAttempts;
        private Boolean shuffleAnswers;
        private String gradeMethod;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(ExamId val) {
            examId = val;
            return this;
        }

        public Builder course(Course val) {
            course = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder score(Float val) {
            score = val;
            return this;
        }

        public Builder maxScore(Float val) {
            maxScore = val;
            return this;
        }

        public Builder timeOpen(ZonedDateTime val) {
            timeOpen = val;
            return this;
        }
        public Builder timeClose(ZonedDateTime val) {
            timeClose = val;
            return this;
        }
        public Builder timeLimit(Integer val) {
            timeLimit = val;
            return this;
        }

        public Builder intro(String val) {
            intro = val;
            return this;
        }

        public Builder overdueHandling(OverdueHandling val) {
            overdueHandling = val;
            return this;
        }

        public Builder canRedoQuestions(Boolean val) {
            canRedoQuestions = val;
            return this;
        }
        public Builder maxAttempts(Integer val) {
            maxAttempts = val;
            return this;
        }

        public Builder shuffleAnswers(Boolean val) {
            shuffleAnswers = val;
            return this;
        }

        public Builder gradeMethod(String val) {
            gradeMethod = val;
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

        public Exam build() {
            return new Exam(this);
        }

        public Builder overdueHanding(OverdueHandling overdueHandling) {
            this.overdueHandling = overdueHandling;
            return this;
        }
    }
}
