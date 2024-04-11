package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ReviewId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.LocalDateTime;

public class Review extends AggregateRoot<ReviewId> {
    private final CertificateCourseId certificateCourseId;
    private String content;
    private Float rating;
    private final UserId createdBy;
    private UserId updatedBy;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Review(Builder builder) {
        super.setId(builder.reviewId);
        certificateCourseId = builder.certificateCourseId;
        content = builder.content;
        rating = builder.rating;
        createdBy = builder.createdBy;
        updatedBy = builder.updatedBy;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public CertificateCourseId getCertificateCourseId() {
        return certificateCourseId;
    }

    public String getContent() {
        return content;
    }

    public Float getRating() {
        return rating;
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
        private ReviewId reviewId;
        private CertificateCourseId certificateCourseId;
        private String content;
        private Float rating;
        private UserId createdBy;
        private UserId updatedBy;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder reviewId(ReviewId val) {
            reviewId = val;
            return this;
        }

        public Builder certificateCourseId(CertificateCourseId val) {
            certificateCourseId = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder rating(Float val) {
            rating = val;
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

        public Review build() {
            return new Review(this);
        }
    }
}
