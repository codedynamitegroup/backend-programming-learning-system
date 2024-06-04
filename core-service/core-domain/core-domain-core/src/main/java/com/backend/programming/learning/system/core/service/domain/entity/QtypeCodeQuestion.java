package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.QtypeCodeQuestionId;

import java.util.UUID;

public class QtypeCodeQuestion extends BaseEntity<QtypeCodeQuestionId> {
    private Question question;
    private String dslTemplate;
    private String problemStatement;
    private String codeQuestionName;
    private Float maxGrade;

    private QtypeCodeQuestion(Builder builder) {
        super.setId(builder.id);
        question = builder.question;
        dslTemplate = builder.dslTemplate;
        problemStatement = builder.problemStatement;
        codeQuestionName = builder.name;
        maxGrade = builder.maxGrade;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void initQtypeCodeQuestion() {
        setId(new QtypeCodeQuestionId(UUID.randomUUID()));
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getDslTemplate() {
        return dslTemplate;
    }

    public String getProblemStatement() {
        return problemStatement;
    }

    public String getCodeQuestionName() {
        return codeQuestionName;
    }

    public Float getMaxGrade() {
        return maxGrade;
    }


    public static final class Builder {
        private QtypeCodeQuestionId id;
        private Question question;
        private String dslTemplate;
        private String problemStatement;
        private String name;
        private Float maxGrade;

        private Builder() {
        }

        public Builder id(QtypeCodeQuestionId val) {
            id = val;
            return this;
        }

        public Builder question(Question val) {
            question = val;
            return this;
        }

        public Builder dslTemplate(String val) {
            dslTemplate = val;
            return this;
        }

        public Builder problemStatement(String val) {
            problemStatement = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder maxGrade(Float val) {
            maxGrade = val;
            return this;
        }

        public QtypeCodeQuestion build() {
            return new QtypeCodeQuestion(this);
        }
    }
}
