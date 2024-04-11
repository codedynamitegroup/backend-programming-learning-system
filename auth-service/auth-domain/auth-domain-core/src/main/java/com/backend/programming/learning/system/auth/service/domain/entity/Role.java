package com.backend.programming.learning.system.auth.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.auth.service.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;

import java.time.LocalDateTime;

public class Role extends AggregateRoot<RoleId> {
    private final OrganizationId organizationId;
    private String description;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserId createdBy;
    private UserId updatedBy;

    private Role(Builder builder) {
        super.setId(builder.roleId);
        organizationId = builder.organizationId;
        description = builder.description;
        name = builder.name;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        createdBy = builder.createdBy;
        updatedBy = builder.updatedBy;
    }

    public OrganizationId getOrganizationId() {
        return organizationId;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public UserId getCreatedBy() {
        return createdBy;
    }

    public UserId getUpdatedBy() {
        return updatedBy;
    }


    public static final class Builder {
        private OrganizationId organizationId;
        private String description;
        private String name;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private UserId createdBy;
        private UserId updatedBy;
        private RoleId roleId;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder organizationId(OrganizationId val) {
            organizationId = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder createdAt(LocalDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedAt(LocalDateTime val) {
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

        public Builder roleId(RoleId val) {
            roleId = val;
            return this;
        }

        public Role build() {
            return new Role(this);
        }
    }
}
