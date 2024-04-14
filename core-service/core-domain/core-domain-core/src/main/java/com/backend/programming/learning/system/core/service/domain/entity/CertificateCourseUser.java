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
    private ZonedDateTime startTime;
    private Boolean isCompleted;
    private ZonedDateTime completedAt;

    public void initializeCertificateCourseUser() {
        setId(new CertificateCourseUserId(UUID.randomUUID()));
    }

    private CertificateCourseUser(Builder builder) {
        super.setId(builder.certificateCourseUserId);
        certificateCourse = builder.certificateCourse;
        user = builder.user;
        startTime = builder.startTime;
        isCompleted = builder.isCompleted;
        completedAt = builder.completedAt;
    }

    public static Builder builder() {
        return new Builder();
    }


    public CertificateCourse getCertificateCourse() {
        return certificateCourse;
    }

    public User getUser() {
        return user;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public ZonedDateTime getCompletedAt() {
        return completedAt;
    }

    public static final class Builder {
        private CertificateCourseUserId certificateCourseUserId;
        private CertificateCourse certificateCourse;
        private User user;
        private ZonedDateTime startTime;
        private Boolean isCompleted;
        private ZonedDateTime completedAt;

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

        public Builder startTime(ZonedDateTime val) {
            startTime = val;
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

        public CertificateCourseUser build() {
            return new CertificateCourseUser(this);
        }
    }
}
