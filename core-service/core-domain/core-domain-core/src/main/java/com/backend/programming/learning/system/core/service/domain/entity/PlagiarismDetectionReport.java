package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.ExamId;
import com.backend.programming.learning.system.core.service.domain.valueobject.PlagiarismDetectionReportId;
import com.backend.programming.learning.system.core.service.domain.valueobject.PlagiarismDetectionReportStatus;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

import java.time.ZonedDateTime;

public class PlagiarismDetectionReport extends AggregateRoot<PlagiarismDetectionReportId> {
    private ProgrammingLanguage programmingLanguage;
    private ExamId examId;
    private Question question;
    private String name;
    private PlagiarismDetectionReportStatus status;
    private String comparedExamIds;
    private String pairsJsonContent;
    private ZonedDateTime createdAt;

    private PlagiarismDetectionReport(Builder builder) {
        super.setId(builder.plagiarismDetectionReportId);
        setProgrammingLanguage(builder.programmingLanguage);
        setExamId(builder.examId);
        setQuestion(builder.question);
        setName(builder.name);
        setStatus(builder.status);
        setComparedExamIds(builder.comparedExamIds);
        setPairsJsonContent(builder.pairsJsonContent);
        setCreatedAt(builder.createdAt);
    }

    public static Builder builder() {
        return new Builder();
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public ExamId getExamId() {
        return examId;
    }

    public void setExamId(ExamId examId) {
        this.examId = examId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlagiarismDetectionReportStatus getStatus() {
        return status;
    }

    public void setStatus(PlagiarismDetectionReportStatus status) {
        this.status = status;
    }

    public String getComparedExamIds() {
        return comparedExamIds;
    }

    public void setComparedExamIds(String comparedExamIds) {
        this.comparedExamIds = comparedExamIds;
    }

    public String getPairsJsonContent() {
        return pairsJsonContent;
    }

    public void setPairsJsonContent(String pairsJsonContent) {
        this.pairsJsonContent = pairsJsonContent;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static final class Builder {
        private PlagiarismDetectionReportId plagiarismDetectionReportId;
        private ProgrammingLanguage programmingLanguage;
        private ExamId examId;
        private Question question;
        private String name;
        private PlagiarismDetectionReportStatus status;
        private String comparedExamIds;
        private String pairsJsonContent;
        private ZonedDateTime createdAt;

        private Builder() {
        }

        public Builder id(PlagiarismDetectionReportId val) {
            plagiarismDetectionReportId = val;
            return this;
        }

        public Builder programmingLanguage(ProgrammingLanguage val) {
            programmingLanguage = val;
            return this;
        }

        public Builder examId(ExamId val) {
            examId = val;
            return this;
        }

        public Builder question(Question val) {
            question = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder status(PlagiarismDetectionReportStatus val) {
            status = val;
            return this;
        }

        public Builder comparedExamIds(String val) {
            comparedExamIds = val;
            return this;
        }

        public Builder pairsJsonContent(String val) {
            pairsJsonContent = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public PlagiarismDetectionReport build() {
            return new PlagiarismDetectionReport(this);
        }
    }
}
