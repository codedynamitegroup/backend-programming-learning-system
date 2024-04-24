package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Organization extends AggregateRoot<OrganizationId> {
    private String name;
    private String description;
    private String moodleUrl;
    private String apiKey;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private Organization(Builder builder) {
        super.setId(builder.organizationId);
        name = builder.name;
        description = builder.description;
        moodleUrl = builder.moodleUrl;
        apiKey = builder.apiKey;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }


    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getApiKey() {
        return apiKey;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoodleUrl(String moodleUrl) {
        this.moodleUrl = moodleUrl;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void initializeOrganization() {
        setId(new OrganizationId(UUID.randomUUID()));
    }

    public static final class Builder {
        private OrganizationId organizationId;
        private String name;
        private String description;
        private String moodleUrl;
        private String apiKey;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;

        private Builder() {
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

        public Organization build() {
            return new Organization(this);
        }
    }
}
