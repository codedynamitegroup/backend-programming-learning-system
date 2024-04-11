package com.backend.programming.learning.system.auth.service.domain.entity;

import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class User extends AggregateRoot<UserId> {
    private String email;
    private String password;
    private LocalDateTime dob;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String avatarUrl;
    private String refreshToken;
    private String lastIp;
    private ZonedDateTime lastLogin;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private boolean isDeleted;

    private User(Builder builder) {
        email = builder.email;
        password = builder.password;
        dob = builder.dob;
        firstName = builder.firstName;
        lastName = builder.lastName;
        phone = builder.phone;
        address = builder.address;
        avatarUrl = builder.avatarUrl;
        refreshToken = builder.refreshToken;
        lastIp = builder.lastIp;
        lastLogin = builder.lastLogin;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        isDeleted = builder.isDeleted;
        setId(builder.userId);
    }

    public void initializeUser() {
        setId(new UserId(UUID.randomUUID()));
        lastLogin = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
        createdAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
        updatedAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
        isDeleted = false;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getLastIp() {
        return lastIp;
    }

    public ZonedDateTime getLastLogin() {
        return lastLogin;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String email;
        private String password;
        private LocalDateTime dob;
        private String firstName;
        private String lastName;
        private String phone;
        private String address;
        private String avatarUrl;
        private String refreshToken;
        private String lastIp;
        private ZonedDateTime lastLogin;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private boolean isDeleted;
        private UserId userId;

        private Builder() {
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder dob(LocalDateTime val) {
            dob = val;
            return this;
        }

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder lastName(String val) {
            lastName = val;
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

        public Builder avatarUrl(String val) {
            avatarUrl = val;
            return this;
        }

        public Builder refreshToken(String val) {
            refreshToken = val;
            return this;
        }

        public Builder lastIp(String val) {
            lastIp = val;
            return this;
        }

        public Builder lastLogin(ZonedDateTime val) {
            lastLogin = val;
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

        public Builder isDeleted(boolean val) {
            isDeleted = val;
            return this;
        }

        public Builder id(UserId val) {
            userId = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
