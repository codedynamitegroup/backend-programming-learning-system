package com.backend.programming.learning.system.domain.entity;

import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZonedDateTime;
import java.util.List;

/***********************************
 * Created by TGT on 31/03/2024.
 * Description: User aggregate root class for core service
 ************************************/

public class User extends AggregateRoot<UserId>{
    private final String name;
    private final String email;
    private final String displayName;
    private final String avatarUrl;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
    private List<String> failureMessage;

    private User(Builder builder) {
        super.setId(builder.userId);
        name = builder.name;
        email = builder.email;
        displayName = builder.displayName;
        avatarUrl = builder.avatarUrl;
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

    public String getDisplayName() {
        return displayName;
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

    public void setFailureMessage(List<String> failureMessage) {
        this.failureMessage = failureMessage;
    }

    public static final class Builder {
        private UserId userId;
        private String name;
        private String email;
        private String displayName;
        private String avatarUrl;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private List<String> failureMessage;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder userId(UserId val) {
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

        public Builder displayName(String val) {
            displayName = val;
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
