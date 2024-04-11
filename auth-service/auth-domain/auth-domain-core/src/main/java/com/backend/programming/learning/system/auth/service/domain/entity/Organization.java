package com.backend.programming.learning.system.auth.service.domain.entity;

import com.backend.programming.learning.system.auth.service.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;

public class Organization extends AggregateRoot<OrganizationId> {
    private String description;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String apiKey;
    private String moodleUrl;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private UserId createdBy;
    private UserId updatedBy;
    private Boolean isDeleted;

    private Organization(Builder builder) {
        super.setId(builder.organizationId);
        description = builder.description;
        name = builder.name;
        email = builder.email;
        phone = builder.phone;
        address = builder.address;
        apiKey = builder.apiKey;
        moodleUrl = builder.moodleUrl;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        createdBy = builder.createdBy;
        updatedBy = builder.updatedBy;
        isDeleted = builder.isDeleted;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getApiKey() {
        return apiKey;
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

    public UserId getCreatedBy() {
        return createdBy;
    }

    public UserId getUpdatedBy() {
        return updatedBy;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }


    public static final class Builder {
        private String description;
        private String name;
        private String email;
        private String phone;
        private String address;
        private String apiKey;
        private String moodleUrl;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private UserId createdBy;
        private UserId updatedBy;
        private Boolean isDeleted;
        private OrganizationId organizationId;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public Builder apiKey(String val) {
            apiKey = val;
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

        public Builder createdBy(UserId val) {
            createdBy = val;
            return this;
        }

        public Builder updatedBy(UserId val) {
            updatedBy = val;
            return this;
        }

        public Builder isDeleted(Boolean val) {
            isDeleted = val;
            return this;
        }

        public Builder organizationId(OrganizationId val) {
            organizationId = val;
            return this;
        }

        public Organization build() {
            return new Organization(this);
        }
    }
}
