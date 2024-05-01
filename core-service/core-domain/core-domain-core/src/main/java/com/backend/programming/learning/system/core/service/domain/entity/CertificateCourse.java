package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseTopicId;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseUserId;
import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class CertificateCourse extends AggregateRoot<CertificateCourseId> {
    private String name;
    private String description;
    private SkillLevel skillLevel;
    private Float avgRating;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private Boolean isDeleted;
    private Topic topic;
    private User createdBy;
    private User updatedBy;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private CertificateCourse(Builder builder) {
        super.setId(builder.certificateCourseId);
        name = builder.name;
        description = builder.description;
        skillLevel = builder.skillLevel;
        avgRating = builder.avgRating;
        startTime = builder.startTime;
        endTime = builder.endTime;
        isDeleted = builder.isDeleted;
        topic = builder.topic;
        createdBy = builder.createdBy;
        updatedBy = builder.updatedBy;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void initializeCertificateCourse() {
        setId(new CertificateCourseId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
        updatedAt = ZonedDateTime.now(ZoneId.of("UTC"));
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

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public Topic getTopic() {
        return topic;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    public void setAvgRating(Float avgRating) {
        this.avgRating = avgRating;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static final class Builder {
        private CertificateCourseId certificateCourseId;
        private String name;
        private String description;
        private SkillLevel skillLevel;
        private Float avgRating;
        private ZonedDateTime startTime;
        private ZonedDateTime endTime;
        private Boolean isDeleted;
        private Topic topic;
        private User createdBy;
        private User updatedBy;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;

        private Builder() {
        }

        public Builder id(CertificateCourseId val) {
            certificateCourseId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder skillLevel(SkillLevel val) {
            skillLevel = val;
            return this;
        }

        public Builder avgRating(Float val) {
            avgRating = val;
            return this;
        }

        public Builder startTime(ZonedDateTime val) {
            startTime = val;
            return this;
        }

        public Builder endTime(ZonedDateTime val) {
            endTime = val;
            return this;
        }

        public Builder isDeleted(Boolean val) {
            isDeleted = val;
            return this;
        }

        public Builder topic(Topic val) {
            topic = val;
            return this;
        }

        public Builder createdBy(User val) {
            createdBy = val;
            return this;
        }

        public Builder updatedBy(User val) {
            updatedBy = val;
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

        public CertificateCourse build() {
            return new CertificateCourse(this);
        }
    }
}
