package com.backend.programming.learning.system.domain.entity;

import com.backend.programming.learning.system.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.domain.valueobject.SkillLevel;
import com.backend.programming.learning.system.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;

public class CertificateCourse extends AggregateRoot<CertificateCourseId> {
    private String name;
    private String description;
    private SkillLevel skillLevel;
    private Float avgRating;
    private TopicId topicId;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private Boolean isDeleted;
    private final UserId createdBy;
    private UserId updatedBy;
    private final ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private CertificateCourse(Builder builder) {
        super.setId(builder.certificateCourseId);
        createdBy = builder.createdBy;
        createdAt = builder.createdAt;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public Float getAvgRating() {
        return avgRating;
    }

    public TopicId getTopicId() {
        return topicId;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public Boolean getDeleted() {
        return isDeleted;
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
        private CertificateCourseId certificateCourseId;
        private UserId createdBy;
        private ZonedDateTime createdAt;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
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

        public CertificateCourse build() {
            return new CertificateCourse(this);
        }
    }
}
