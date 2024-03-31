package com.backend.programming.learning.system.domain.entity;

import com.backend.programming.learning.system.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;

public class Chapter extends BaseEntity<ChapterId> {
    private final CertificateCourseId certificateCourseId;
    private int no;
    private String title;
    private String description;
    private final UserId createdBy;
    private UserId updatedBy;
    private final ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private Chapter(Builder builder) {
        super.setId(builder.chapterId);
        certificateCourseId = builder.certificateCourseId;
        createdBy = builder.createdBy;
        createdAt = builder.createdAt;
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

    public UserId getCreatedBy() {
        return createdBy;
    }

    public UserId getUpdatedBy() {
        return updatedBy;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static final class Builder {
        private ChapterId chapterId;
        private CertificateCourseId certificateCourseId;
        private UserId createdBy;
        private ZonedDateTime createdAt;

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

        public Builder createdBy(UserId val) {
            createdBy = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Chapter build() {
            return new Chapter(this);
        }
    }
}
