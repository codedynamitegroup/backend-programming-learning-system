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
    private Boolean isPublic;

    private QtypeCodeQuestion(Builder builder) {
        super.setId(builder.qtypeCodeQuestionId);
        setQuestion(builder.question);
        setDslTemplate(builder.dslTemplate);
        setProblemStatement(builder.problemStatement);
        setCodeQuestionName(builder.codeQuestionName);
        setMaxGrade(builder.maxGrade);
        isPublic = builder.isPublic;
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

    public void setDslTemplate(String dslTemplate) {
        this.dslTemplate = dslTemplate;
    }

    public String getProblemStatement() {
        return problemStatement;
    }

    public void setProblemStatement(String problemStatement) {
        this.problemStatement = problemStatement;
    }

    public String getCodeQuestionName() {
        return codeQuestionName;
    }

    public void setCodeQuestionName(String codeQuestionName) {
        this.codeQuestionName = codeQuestionName;
    }

    public Float getMaxGrade() {
        return maxGrade;
    }

    public void setMaxGrade(Float maxGrade) {
        this.maxGrade = maxGrade;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public static final class Builder {
        private QtypeCodeQuestionId qtypeCodeQuestionId;
        private Question question;
        private String dslTemplate;
        private String problemStatement;
        private String codeQuestionName;
        private Float maxGrade;
        private Boolean isPublic;

        private Builder() {
        }

        public Builder id(QtypeCodeQuestionId val) {
            qtypeCodeQuestionId = val;
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

        public Builder codeQuestionName(String val) {
            codeQuestionName = val;
            return this;
        }

        public Builder maxGrade(Float val) {
            maxGrade = val;
            return this;
        }

        public Builder isPublic(Boolean val) {
            isPublic = val;
            return this;
        }

        public QtypeCodeQuestion build() {
            return new QtypeCodeQuestion(this);
        }
    }
}
