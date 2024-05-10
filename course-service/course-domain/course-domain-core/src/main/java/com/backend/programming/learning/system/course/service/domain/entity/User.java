package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class User extends AggregateRoot<UserId> {
    private Integer userIdMoodle;
    private  String name;
    private String email;
    private ZonedDateTime dob;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String avatarUrl;
    private ZonedDateTime lastLogin;
    private Boolean isDeleted;
    private ZonedDateTime createdAt;
    private  ZonedDateTime updatedAt;
    private List<String> failureMessage;

    private User(Builder builder) {
        super.setId(builder.userId);
        userIdMoodle = builder.userIdMoodle;
        name = builder.name;
        email = builder.email;
        dob = builder.dob;
        firstName = builder.firstName;
        lastName = builder.lastName;
        phone = builder.phone;
        address = builder.address;
        avatarUrl = builder.avatarUrl;
        lastLogin = builder.lastLogin;
        isDeleted = builder.isDeleted;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        failureMessage = builder.failureMessage;
    }

    public Integer getUserIdMoodle() {
        return userIdMoodle;
    }

    public void setUserIdMoodle(Integer userIdMoodle) {
        this.userIdMoodle = userIdMoodle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setLastLogin(ZonedDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setFailureMessage(List<String> failureMessage) {
        this.failureMessage = failureMessage;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
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

    public ZonedDateTime getLastLogin() {
        return lastLogin;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public List<String> getFailureMessage() {
        return failureMessage;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public void initializeUser() {
        setId(new UserId(UUID.randomUUID()));
        lastLogin = ZonedDateTime.now(ZoneId.of(DomainConstants.UTC));
        createdAt = ZonedDateTime.now(ZoneId.of(DomainConstants.UTC));
        updatedAt = ZonedDateTime.now(ZoneId.of(DomainConstants.UTC));
        isDeleted = false;
    }

    public static final class Builder {
        private UserId userId;
        private Integer userIdMoodle;
        private String name;
        private String email;
        private ZonedDateTime dob;
        private String firstName;
        private String lastName;
        private String phone;
        private String address;
        private String avatarUrl;
        private ZonedDateTime lastLogin;
        private Boolean isDeleted;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private List<String> failureMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(UserId val) {
            userId = val;
            return this;
        }

        public Builder userIdMoodle(Integer val) {
            userIdMoodle = val;
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

        public Builder lastLogin(ZonedDateTime val) {
            lastLogin = val;
            return this;
        }

        public Builder isDeleted(Boolean val) {
            isDeleted = val;
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

        public Builder failureMessage(List<String> val) {
            failureMessage = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
