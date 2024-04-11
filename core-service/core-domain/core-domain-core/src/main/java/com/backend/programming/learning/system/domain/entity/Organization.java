package com.backend.programming.learning.system.domain.entity;

import com.backend.programming.learning.system.domain.valueobject.OrganizationId;

import java.time.ZonedDateTime;

public class Organization extends AggregateRoot<OrganizationId> {
    private final String name;
    private final String description;
    private final String moodleUrl;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;

    private Organization(Builder builder) {
        super.setId(builder.organizationId);
        name = builder.name;
        description = builder.description;
        moodleUrl = builder.moodleUrl;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public static Builder builder() {
        return new Builder();
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


    public static final class Builder {
        private OrganizationId organizationId;
        private String name;
        private String description;
        private String moodleUrl;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;

        private Builder() {
        }

        public Builder organizationId(OrganizationId val) {
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
