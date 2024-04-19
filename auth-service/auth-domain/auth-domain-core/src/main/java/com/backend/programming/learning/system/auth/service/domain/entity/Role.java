package com.backend.programming.learning.system.auth.service.domain.entity;

import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Role extends AggregateRoot<RoleId> {
    private final Organization organization;
    private String description;
    private String name;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private User createdBy;
    private User updatedBy;

    public void initializeRole() {
        setId(new RoleId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
        updatedAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
    }


    private Role(Builder builder) {
        super.setId(builder.roleId);
        organization = builder.Organization;
        description = builder.description;
        name = builder.name;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        createdBy = builder.createdBy;
        updatedBy = builder.updatedBy;
    }

    public Organization getOrganization() {
        return organization;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
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

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Organization Organization;
        private String description;
        private String name;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private User createdBy;
        private User updatedBy;
        private RoleId roleId;

        private Builder() {
        }

        public Builder organization(Organization val) {
            Organization = val;
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

        public Builder id(RoleId val) {
            roleId = val;
            return this;
        }

        public Role build() {
            return new Role(this);
        }
    }
}
