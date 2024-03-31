package com.backend.programming.learning.system.domain.entity;

import com.backend.programming.learning.system.domain.valueobject.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class CertificateCourse extends AggregateRoot<CertificateCourseId> {
    private String name;
    private String description;
    private SkillLevel skillLevel;
    private Float avgRating;
    private TopicId topicId;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private Boolean isDeleted;
    private final List<Chapter> chapters;
    private final UserId createdBy;
    private UserId updatedBy;
    private final ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private List<String> failureMessages;

    public static final String FAILURE_MESSAGE_DELIMITER = ",";

    public void initializeCertificateCourse() {
        setId(new CertificateCourseId(UUID.randomUUID()));
        initializeChapters();
    }

    private void initializeChapters() {
        int itemId = 1;
        for (Chapter chapter: chapters) {
            chapter.initializeChapter(super.getId(), new ChapterId(UUID.randomUUID()), itemId++);
        }
    }

    private CertificateCourse(Builder builder) {
        super.setId(builder.certificateCourseId);
        name = builder.name;
        description = builder.description;
        skillLevel = builder.skillLevel;
        avgRating = builder.avgRating;
        topicId = builder.topicId;
        startTime = builder.startTime;
        endTime = builder.endTime;
        isDeleted = builder.isDeleted;
        chapters = builder.chapters;
        createdBy = builder.createdBy;
        updatedBy = builder.updatedBy;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        failureMessages = builder.failureMessages;
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

    public List<Chapter> getChapters() {
        return chapters;
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

    public List<String> getFailureMessages() {
        return failureMessages;
    }

    public static final class Builder {
        private CertificateCourseId certificateCourseId;
        private String name;
        private String description;
        private SkillLevel skillLevel;
        private Float avgRating;
        private TopicId topicId;
        private ZonedDateTime startTime;
        private ZonedDateTime endTime;
        private Boolean isDeleted;
        private List<Chapter> chapters;
        private UserId createdBy;
        private UserId updatedBy;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private List<String> failureMessages;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder certificateCourseId(CertificateCourseId val) {
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

        public Builder topicId(TopicId val) {
            topicId = val;
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

        public Builder chapters(List<Chapter> val) {
            chapters = val;
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

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedAt(ZonedDateTime val) {
            updatedAt = val;
            return this;
        }

        public Builder failureMessages(List<String> val) {
            failureMessages = val;
            return this;
        }

        public CertificateCourse build() {
            return new CertificateCourse(this);
        }
    }
}
