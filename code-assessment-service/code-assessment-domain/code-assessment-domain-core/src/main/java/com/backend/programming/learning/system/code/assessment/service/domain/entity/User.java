package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

public class User extends AggregateRoot<UserId> {
    private final String name;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final Date dob;
    private final String avatarUrl;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
    private List<String> failureMessage;

    private User(Builder builder) {
        super.setId(builder.userId);
        name = builder.name;
        email = builder.email;
        firstName = builder.firstName;
        lastName = builder.lastName;
        dob = builder.dob;
        avatarUrl = builder.avatarUrl;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        failureMessage = builder.failureMessage;
    }

    public static Builder builder() {
        return new Builder();
    }


    public String getName() {
        return name;
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

    public Date getDob() {
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

    public List<String> getFailureMessage() {
        return failureMessage;
    }

    public static final class Builder {
        private UserId userId;
        private String name;
        private String email;
        private String firstName;
        private String lastName;
        private Date dob;
        private String avatarUrl;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private List<String> failureMessage;

        private Builder() {
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

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder lastName(String val) {
            lastName = val;
            return this;
        }

        public Builder dob(Date val) {
            dob = val;
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

        public Builder failureMessage(List<String> val) {
            failureMessage = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}