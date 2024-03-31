package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.BaseEntity;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.valueobject.RoleId;
import com.backend.programming.learning.system.valueobject.UserRoleId;

import java.time.LocalDateTime;

public class UserRole extends BaseEntity<UserRoleId> {
    private final UserId userId;
    private final RoleId roleId;
    private boolean isActive;
    private String name;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private final UserId createdBy;
    private UserId updatedBy;

    private UserRole(Builder builder) {
        super.setId(builder.userRoleId);
        userId = builder.userId;
        roleId = builder.roleId;
        isActive = builder.isActive;
        name = builder.name;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        createdBy = builder.createdBy;
        updatedBy = builder.updatedBy;
    }

    public UserId getUserId() {
        return userId;
    }

    public RoleId getRoleId() {
        return roleId;
    }

    public boolean isActive() {
        return isActive;
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
        private UserId userId;
        private RoleId roleId;
        private boolean isActive;
        private String name;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private UserId createdBy;
        private UserId updatedBy;
        private UserRoleId userRoleId;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder roleId(RoleId val) {
            roleId = val;
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

        public Builder userRoleId(UserRoleId val) {
            userRoleId = val;
            return this;
        }

        public UserRole build() {
            return new UserRole(this);
        }
    }
}
