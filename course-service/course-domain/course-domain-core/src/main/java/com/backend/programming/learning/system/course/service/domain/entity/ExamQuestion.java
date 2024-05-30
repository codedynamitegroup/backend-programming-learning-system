package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamQuestionId;

import java.util.UUID;

public class ExamQuestion extends AggregateRoot<ExamQuestionId> {
    private Exam exam;
    private Question question;
    private Integer page;

    private ExamQuestion(Builder builder) {
        super.setId(builder.examQuestionId);
        exam = builder.exam;
        question = builder.question;
        page = builder.page;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Exam getExam() {
        return exam;
    }

    public Question getQuestion() {
        return question;
    }

    public Integer getPage() {
        return page;
    }

    public void initializeExamQuestion() {
        setId(new ExamQuestionId(UUID.randomUUID()));
    }

    public static final class Builder {
        private ExamQuestionId examQuestionId;
        private Exam exam;
        private Question question;
        private Integer page;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(ExamQuestionId val) {
            examQuestionId = val;
            return this;
        }

        public Builder exam(Exam val) {
            exam = val;
            return this;
        }

        public Builder question(Question val) {
            question = val;
            return this;
        }

        public Builder page(Integer val) {
            page = val;
            return this;
        }

        public ExamQuestion build() {
            return new ExamQuestion(this);
        }
    }
}
