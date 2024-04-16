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

public class ChapterQuestion extends BaseEntity<ChapterQuestionId> {
    private final Question question;
    private final Chapter chapter;

    private ChapterQuestion(Builder builder) {
        super.setId(builder.chapterQuestionId);
        question = builder.question;
        chapter = builder.chapter;
    }

    public static Builder builder() {
        return new Builder();
    }


    public Question getQuestion() {
        return question;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public static final class Builder {
        private ChapterQuestionId chapterQuestionId;
        private Question question;
        private Chapter chapter;

        private Builder() {
        }

        public Builder id(ChapterQuestionId val) {
            chapterQuestionId = val;
            return this;
        }

        public Builder question(Question val) {
            question = val;
            return this;
        }

        public Builder chapter(Chapter val) {
            chapter = val;
            return this;
        }

        public ChapterQuestion build() {
            return new ChapterQuestion(this);
        }
    }
}
