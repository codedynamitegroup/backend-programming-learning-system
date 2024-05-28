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

    public void initializeUserRole() {
        setId(new UserRoleId(UUID.randomUUID()));
    }

    public static Builder builder() {
        return new Builder();
    }

    private UserRole(Builder builder) {
        super.setId(builder.userRoleId);
        user = builder.user;
        role = builder.role;
    }

    public User getUser() {
        return user;
    }

    public Role getRole() {
        return role;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public static final class Builder {
        private User user;
        private Role role;
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

        public Builder id(UserRoleId val) {
            userRoleId = val;
            return this;
        }

        public UserRole build() {
            return new UserRole(this);
        }
    }
}
