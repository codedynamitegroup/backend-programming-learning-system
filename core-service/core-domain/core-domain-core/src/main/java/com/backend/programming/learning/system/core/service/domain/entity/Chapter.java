package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.LocalDateTime;
import java.util.List;

public class Chapter extends BaseEntity<ChapterId> {
    private CertificateCourseId certificateCourseId;
    private int no;
    private String title;
    private String description;
    private final List<QtypeCodeQuestion> qtypeCodeQuestions;
    private final UserId createdBy;
    private UserId updatedBy;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    void initializeChapter(CertificateCourseId certificateCourseId, ChapterId chapterId, int no) {
        this.certificateCourseId = certificateCourseId;
        this.no = no;
        super.setId(chapterId);
    }

    private Chapter(Builder builder) {
        super.setId(builder.chapterId);
        certificateCourseId = builder.certificateCourseId;
        no = builder.no;
        title = builder.title;
        description = builder.description;
        qtypeCodeQuestions = builder.qtypeCodeQuestions;
        createdBy = builder.createdBy;
        updatedBy = builder.updatedBy;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public CertificateCourseId getCertificateCourseId() {
        return certificateCourseId;
    }

    public int getNo() {
        return no;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<QtypeCodeQuestion> getQtypeCodeQuestions() {
        return qtypeCodeQuestions;
    }

    public UserId getCreatedBy() {
        return createdBy;
    }

    public UserId getUpdatedBy() {
        return updatedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static final class Builder {
        private ChapterId chapterId;
        private CertificateCourseId certificateCourseId;
        private int no;
        private String title;
        private String description;
        private List<QtypeCodeQuestion> qtypeCodeQuestions;
        private UserId createdBy;
        private UserId updatedBy;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder chapterId(ChapterId val) {
            chapterId = val;
            return this;
        }

        public Builder certificateCourseId(CertificateCourseId val) {
            certificateCourseId = val;
            return this;
        }

        public Builder no(int val) {
            no = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder qtypeCodeQuestions(List<QtypeCodeQuestion> val) {
            qtypeCodeQuestions = val;
            return this;
        }

        public Builder createdBy(UserId val) {
            createdBy = val;
            return this;
        }

        public Builder updatedBy(UserId val) {
            updatedBy = val;
            return this;
        }

        public Builder createdAt(LocalDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedAt(LocalDateTime val) {
            updatedAt = val;
            return this;
        }

        public Chapter build() {
            return new Chapter(this);
        }
    }
}
