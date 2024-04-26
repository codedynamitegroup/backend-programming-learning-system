package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;


public class User extends AggregateRoot<UserId> {
    private final String name;
    private final String email;
    private final Date dob;
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String address;
    private final String avatarUrl;
    private final ZonedDateTime lastLogin;
    private final Boolean isDeleted;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
    private List<String> failureMessage;

    private User(Builder builder) {
        super.setId(builder.userId);
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

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getDob() {
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

    public static final class Builder {
        private UserId userId;
        private String name;
        private String email;
        private Date dob;
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

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder dob(Date val) {
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
