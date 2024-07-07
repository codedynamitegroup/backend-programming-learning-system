package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.AssignmentAIGradeReportId;
import com.backend.programming.learning.system.course.service.domain.valueobject.RubricUserId;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class RubricUser extends AggregateRoot<RubricUserId> {
    private String content;
    private String name;
    private String description;
    private User user;

    private RubricUser(Builder builder) {
        super.setId(builder.rubricUserId);
        setContent(builder.content);
        setUser(builder.user);
        name = builder.name;
        description = builder.description;
    }

    public void initializeRubricUser() {
        setId(new RubricUserId(UUID.randomUUID()));
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private RubricUserId rubricUserId;
        private String content;
        private User user;
        private String name;
        private String description;

        private Builder() {
        }

        public Builder id(RubricUserId val) {
            rubricUserId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public RubricUser build() {
            return new RubricUser(this);
        }
    }
}
