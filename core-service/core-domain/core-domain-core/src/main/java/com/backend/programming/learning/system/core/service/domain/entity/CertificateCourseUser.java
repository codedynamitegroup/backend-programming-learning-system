package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseTopicId;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseUserId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;

public class CertificateCourseUser extends AggregateRoot<CertificateCourseUserId> {
    private CertificateCourseId certificateCourseId;
    private UserId userId;
    private ZonedDateTime startTime;
    private Boolean isCompleted;
    private ZonedDateTime completedAt;

    private CertificateCourseUser(Builder builder) {
        super.setId(builder.certificateCourseUserId);
        certificateCourseId = builder.certificateCourseId;
        userId = builder.userId;
        startTime = builder.startTime;
        isCompleted = builder.isCompleted;
        completedAt = builder.completedAt;
    }

    public static Builder builder() {
        return new Builder();
    }


    public CertificateCourseId getCertificateCourseId() {
        return certificateCourseId;
    }

    public UserId getUserId() {
        return userId;
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
        private CertificateCourseId certificateCourseId;
        private UserId userId;
        private ZonedDateTime startTime;
        private Boolean isCompleted;
        private ZonedDateTime completedAt;

        private Builder() {
        }

        public Builder id(CertificateCourseUserId val) {
            certificateCourseUserId = val;
            return this;
        }

        public Builder certificateCourseId(CertificateCourseId val) {
            certificateCourseId = val;
            return this;
        }

        public Builder userId(UserId val) {
            userId = val;
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
