package com.backend.programming.learning.system.core.service.domain.dto.responseentity.question;

public class QtypeCodeQuestionResponseEntity {
    private final QuestionResponseEntity question;
    private final String id;
    private final String dslTemplate;
    private final String problemStatement;
    private final String codeQuestionName;
    private final Float maxGrade;

    public QuestionResponseEntity getQuestion() {
        return question;
    }

    public String getId() {
        return id;
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

    private QtypeCodeQuestionResponseEntity(Builder builder) {
        question = builder.question;
        id = builder.id;
        dslTemplate = builder.dslTemplate;
        problemStatement = builder.problemStatement;
        codeQuestionName = builder.codeQuestionName;
        maxGrade = builder.maxGrade;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private QuestionResponseEntity question;
        private String id;
        private String dslTemplate;
        private String problemStatement;
        private String codeQuestionName;
        private Float maxGrade;

        private Builder() {
        }

        public Builder question(QuestionResponseEntity val) {
            question = val;
            return this;
        }

        public Builder id(String val) {
            id = val;
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

        public Builder codeQuestionName(String val) {
            codeQuestionName = val;
            return this;
        }

        public Builder maxGrade(Float val) {
            maxGrade = val;
            return this;
        }

        public QtypeCodeQuestionResponseEntity build() {
            return new QtypeCodeQuestionResponseEntity(this);
        }
    }
}
