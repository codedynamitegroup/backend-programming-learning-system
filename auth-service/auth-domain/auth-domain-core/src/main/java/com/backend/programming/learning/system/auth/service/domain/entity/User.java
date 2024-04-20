package com.backend.programming.learning.system.auth.service.domain.entity;

import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class User extends AggregateRoot<UserId> {
    private String email;
    private String password;
    private ZonedDateTime dob;
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
    private Boolean isDeleted;

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

    public void deleteUser() {
        isDeleted = true;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ZonedDateTime getDob() {
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDob(ZonedDateTime dob) {
        this.dob = dob;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public void setLastLogin(ZonedDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String email;
        private String password;
        private ZonedDateTime dob;
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

        public Builder dob(ZonedDateTime val) {
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
