package com.backend.programming.learning.system.domain.entity;

import com.backend.programming.learning.system.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.domain.valueobject.ReviewId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;

public class Review extends AggregateRoot<ReviewId> {
    private final CertificateCourseId certificateCourseId;
    private String content;
    private Float rating;
    private final UserId createdBy;
    private UserId updatedBy;
    private final ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private Review(Builder builder) {
        super.setId(builder.reviewId);
        certificateCourseId = builder.certificateCourseId;
        createdBy = builder.createdBy;
        createdAt = builder.createdAt;
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

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static final class Builder {
        private ReviewId reviewId;
        private CertificateCourseId certificateCourseId;
        private UserId createdBy;
        private ZonedDateTime createdAt;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(ReviewId val) {
            reviewId = val;
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

        public Review build() {
            return new Review(this);
        }
    }
}
