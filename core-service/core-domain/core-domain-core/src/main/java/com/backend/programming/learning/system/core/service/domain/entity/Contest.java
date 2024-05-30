package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class Contest extends AggregateRoot<ContestId> {
    private String name;
    private String description;
    private String thumbnailUrl;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private Integer numOfParticipants;
    private List<ContestQuestion> questions;
    private Boolean isRegistered;
    private User createdBy;
    private User updatedBy;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private Contest(Builder builder) {
        super.setId(builder.contestId);
        setName(builder.name);
        setDescription(builder.description);
        setThumbnailUrl(builder.thumbnailUrl);
        setStartTime(builder.startTime);
        setEndTime(builder.endTime);
        setNumOfParticipants(builder.numOfParticipants);
        setQuestions(builder.questions);
        isRegistered = builder.isRegistered;
        setCreatedBy(builder.createdBy);
        setUpdatedBy(builder.updatedBy);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
    }

    public static Builder builder() {
        return new Builder();
    }

    public void initializeContest() {
        setId(new ContestId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
        updatedAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getNumOfParticipants() {
        return numOfParticipants;
    }

    public void setNumOfParticipants(Integer numOfParticipants) {
        this.numOfParticipants = numOfParticipants;
    }

    public List<ContestQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<ContestQuestion> questions) {
        this.questions = questions;
    }

    public Boolean getRegistered() {
        return isRegistered;
    }

    public void setRegistered(Boolean registered) {
        isRegistered = registered;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static final class Builder {
        private ContestId contestId;
        private String name;
        private String description;
        private String thumbnailUrl;
        private ZonedDateTime startTime;
        private ZonedDateTime endTime;
        private Integer numOfParticipants;
        private List<ContestQuestion> questions;
        private Boolean isRegistered;
        private User createdBy;
        private User updatedBy;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;

        private Builder() {
        }

        public Builder id(ContestId val) {
            contestId = val;
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

        public Builder thumbnailUrl(String val) {
            thumbnailUrl = val;
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

        public Builder numOfParticipants(Integer val) {
            numOfParticipants = val;
            return this;
        }

        public Builder questions(List<ContestQuestion> val) {
            questions = val;
            return this;
        }

        public Builder isRegistered(Boolean val) {
            isRegistered = val;
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

        public Contest build() {
            return new Contest(this);
        }
    }
}
