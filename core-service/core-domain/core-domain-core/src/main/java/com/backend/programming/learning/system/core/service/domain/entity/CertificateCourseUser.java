package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.*;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class CertificateCourseUser extends AggregateRoot<CertificateCourseUserId> {
    private CertificateCourse certificateCourse;
    private User user;
    private Boolean isCompleted;
    private ZonedDateTime completedAt;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private CertificateCourseUser(Builder builder) {
        super.setId(builder.certificateCourseUserId);
        certificateCourse = builder.certificateCourse;
        user = builder.user;
        isCompleted = builder.isCompleted;
        completedAt = builder.completedAt;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void initializeCertificateCourseUser() {
        setId(new CertificateCourseUserId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
        updatedAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
    }


    public CertificateCourse getCertificateCourse() {
        return certificateCourse;
    }

    public User getUser() {
        return user;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public ZonedDateTime getCompletedAt() {
        return completedAt;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static final class Builder {
        private CertificateCourseUserId certificateCourseUserId;
        private CertificateCourse certificateCourse;
        private User user;
        private Boolean isCompleted;
        private ZonedDateTime completedAt;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;

        private Builder() {
        }

        public Builder id(CertificateCourseUserId val) {
            certificateCourseUserId = val;
            return this;
        }

        public Builder certificateCourse(CertificateCourse val) {
            certificateCourse = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder isCompleted(Boolean val) {
            isCompleted = val;
            return this;
        }

        public Builder completedAt(ZonedDateTime val) {
            completedAt = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedAt(ZonedDateTime val) {
            updatedAt = val;
            return this;
        }

        public CertificateCourseUser build() {
            return new CertificateCourseUser(this);
        }
    }
}
