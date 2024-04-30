package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

public class User extends AggregateRoot<UserId> {
    private String email;
    private String firstName;
    private String lastName;
    private ZonedDateTime dob;
    private String phone;
    private String address;
    private String avatarUrl;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private Boolean isDeleted;

    private User(Builder builder) {
        super.setId(builder.userId);
        email = builder.email;
        firstName = builder.firstName;
        lastName = builder.lastName;
        dob = builder.dob;
        phone = builder.phone;
        address = builder.address;
        avatarUrl = builder.avatarUrl;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        isDeleted = builder.isDeleted;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ZonedDateTime getDob() {
        return dob;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UserId userId;
        private String email;
        private String firstName;
        private String lastName;
        private ZonedDateTime dob;
        private String phone;
        private String address;
        private String avatarUrl;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private Boolean isDeleted;

        private Builder() {
        }

        public Builder id(UserId val) {
            userId = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
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

        public Builder dob(ZonedDateTime val) {
            dob = val;
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

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedAt(ZonedDateTime val) {
            updatedAt = val;
            return this;
        }

        public Builder isDeleted(Boolean val) {
            isDeleted = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}