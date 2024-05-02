package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;

import java.time.ZonedDateTime;

public class Organization extends AggregateRoot<OrganizationId> {
    private String name;
    private String description;
    private String moodleUrl;
    private String apiKey;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private CopyState copyState;
    private Boolean isDeleted;

    private Organization(Builder builder) {
        super.setId(builder.organizationId);
        name = builder.name;
        description = builder.description;
        moodleUrl = builder.moodleUrl;
        setApiKey(builder.apiKey);
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        setCopyState(builder.copyState);
        isDeleted = builder.isDeleted;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getMoodleUrl() {
        return moodleUrl;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getApiKey() {
        return apiKey;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public CopyState getCopyState() {
        return copyState;
    }

    public void setCopyState(CopyState copyState) {
        this.copyState = copyState;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMoodleUrl(String moodleUrl) {
        this.moodleUrl = moodleUrl;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }



    public static final class Builder {
        private OrganizationId organizationId;
        private String name;
        private String description;
        private String moodleUrl;
        private String apiKey;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private CopyState copyState;
        private Boolean isDeleted;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(OrganizationId val) {
            organizationId = val;
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

        public Builder moodleUrl(String val) {
            moodleUrl = val;
            return this;
        }

        public Builder apiKey(String val) {
            apiKey = val;
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

        public Builder copyState(CopyState val) {
            copyState = val;
            return this;
        }

        public Builder isDeleted(Boolean val) {
            isDeleted = val;
            return this;
        }

        public Organization build() {
            return new Organization(this);
        }
    }
}
