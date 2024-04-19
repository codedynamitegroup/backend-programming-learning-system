package com.backend.programming.learning.system.auth.service.domain.entity;

import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

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
    private User createdBy;
    private User updatedBy;
    private Boolean isDeleted;

    public void initializeOrganization() {
        setId(new OrganizationId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
        updatedAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
        isDeleted = false;
    }

    public void deleteOrganization() {
        isDeleted = true;
    }

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

    public User getCreatedBy() {
        return createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
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

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public static Builder builder() {
        return new Builder();
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
        private User createdBy;
        private User updatedBy;
        private Boolean isDeleted;
        private OrganizationId organizationId;

        private Builder() {
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

        public Builder createdBy(User val) {
            createdBy = val;
            return this;
        }

        public Builder updatedBy(User val) {
            updatedBy = val;
            return this;
        }

        public Builder isDeleted(Boolean val) {
            isDeleted = val;
            return this;
        }

        public Builder id(OrganizationId val) {
            organizationId = val;
            return this;
        }

        public Organization build() {
            return new Organization(this);
        }
    }
}
