package com.backend.programming.learning.system.auth.service.domain.entity;

import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.auth.service.domain.valueobject.UserRoleId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class UserRole extends BaseEntity<UserRoleId> {
    private User user;
    private Role role;
    private boolean isActive;
    private String name;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private User createdBy;
    private User updatedBy;

    public void initializeUserRole() {
        setId(new UserRoleId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
        updatedAt = ZonedDateTime.now(ZoneId.of("UTC"));
        isActive = true;
    }

    public static Builder builder() {
        return new Builder();
    }

    private UserRole(Builder builder) {
        super.setId(builder.userRoleId);
        user = builder.user;
        role = builder.role;
        isActive = builder.isActive;
        name = builder.name;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        createdBy = builder.createdBy;
        updatedBy = builder.updatedBy;
    }

    public User getUser() {
        return user;
    }

    public Role getRole() {
        return role;
    }

    public boolean isActive() {
        return isActive;
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

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public static final class Builder {
        private User user;
        private Role role;
        private boolean isActive;
        private String name;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private User createdBy;
        private User updatedBy;
        private UserRoleId userRoleId;

        private Builder() {
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder role(Role val) {
            role = val;
            return this;
        }

        public Builder isActive(boolean val) {
            isActive = val;
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

        public Builder id(UserRoleId val) {
            userRoleId = val;
            return this;
        }

        public UserRole build() {
            return new UserRole(this);
        }
    }
}
