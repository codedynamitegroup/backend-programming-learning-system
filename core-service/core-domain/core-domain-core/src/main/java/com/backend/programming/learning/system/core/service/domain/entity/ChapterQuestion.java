package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterQuestionId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;
import java.util.List;

public class ChapterQuestion extends AggregateRoot<ChapterQuestionId> {
    private final QuestionId questionId;
    private final ChapterId chapterId;
    private Float grade;
    private Boolean pass;

    private ChapterQuestion(Builder builder) {
        super.setId(builder.chapterQuestionId);
        questionId = builder.questionId;
        chapterId = builder.chapterId;
        grade = builder.grade;
        pass = builder.pass;
    }

    public static Builder builder() {
        return new Builder();
    }

    public QuestionId getQuestionId() {
        return questionId;
    }

    public ChapterId getChapterId() {
        return chapterId;
    }

    public Float getGrade() {
        return grade;
    }

    public Boolean getPass() {
        return pass;
    }

    public static final class Builder {
        private ChapterQuestionId chapterQuestionId;
        private QuestionId questionId;
        private ChapterId chapterId;
        private Float grade;
        private Boolean pass;

        private Builder() {
        }

        public Builder id(ChapterQuestionId val) {
            chapterQuestionId = val;
            return this;
        }

        public Builder questionId(QuestionId val) {
            questionId = val;
            return this;
        }

        public Builder chapterId(ChapterId val) {
            chapterId = val;
            return this;
        }

        public Builder grade(Float val) {
            grade = val;
            return this;
        }

        public Builder pass(Boolean val) {
            pass = val;
            return this;
        }

        public ChapterQuestion build() {
            return new ChapterQuestion(this);
        }
    }
}
