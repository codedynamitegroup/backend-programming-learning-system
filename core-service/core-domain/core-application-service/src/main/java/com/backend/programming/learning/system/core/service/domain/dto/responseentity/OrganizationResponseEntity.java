package com.backend.programming.learning.system.core.service.domain.dto.responseentity;

import java.time.ZonedDateTime;


public class OrganizationResponseEntity {
    private final String id;
    private final String name;
    private final String description;
    private final String moodleUrl;
    private final String apiKey;
    private final Boolean isDeleted;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;

    public String getId() {
        return id;
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

    public String getApiKey() {
        return apiKey;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    private OrganizationResponseEntity(Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
        moodleUrl = builder.moodleUrl;
        apiKey = builder.apiKey;
        isDeleted = builder.isDeleted;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private String id;
        private String name;
        private String description;
        private String moodleUrl;
        private String apiKey;
        private Boolean isDeleted;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
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

        public Builder isDeleted(Boolean val) {
            isDeleted = val;
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

        public OrganizationResponseEntity build() {
            return new OrganizationResponseEntity(this);
        }
    }
}
