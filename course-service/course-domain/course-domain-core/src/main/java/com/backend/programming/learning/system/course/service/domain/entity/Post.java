package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.course.service.domain.valueobject.PostId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Post extends AggregateRoot<PostId> {
    private Course course;
    private String title;
    private String content;
    private String summary;
    private Boolean isPublished;

    private final User createdBy;
    private User updatedBy;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    void initializePost(Course course, PostId postId) {
        this.course = course;
        this.setId(postId);
    }
    public void initializePost() {
        setId(new PostId(UUID.randomUUID()));
        createdAt =  ZonedDateTime.now(ZoneId.of("UTC"));
        updatedAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }
    private Post(Builder builder) {
        super.setId(builder.postId);
        course = builder.course;
        title = builder.title;
        content = builder.content;
        summary = builder.summary;
        isPublished = builder.isPublished;
        createdBy = builder.createdBy;
        updatedBy = builder.updatedBy;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Course getCourse() {
        return course;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getSummary() {
        return summary;
    }

    public Boolean getPublished() {
        return isPublished;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static final class Builder {
        private PostId postId;
        private Course course;
        private String title;
        private String content;
        private String summary;
        private Boolean isPublished;
        private User createdBy;
        private User updatedBy;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(PostId val) {
            postId = val;
            return this;
        }

        public Builder course(Course val) {
            course = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder summary(String val) {
            summary = val;
            return this;
        }

        public Builder isPublished(Boolean val) {
            isPublished = val;
            return this;
        }

        public Builder createdBy(User val) {
            createdBy = val;
            return this;
        }

        public Builder updatedBy(User val) {
            updatedBy = val;
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

        public Post build() {
            return new Post(this);
        }
    }
}
