package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.valueobject.CourseId;
import com.backend.programming.learning.system.valueobject.PostId;

import java.time.ZonedDateTime;

public class Post extends AggregateRoot<PostId> {
    private CourseId courseId;
    private String title;
    private String content;
    private String summary;
    private Boolean isPublished;

    private final UserId createdBy;
    private UserId updatedBy;

    private final ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    void initializePost(CourseId courseId, PostId postId) {
        this.courseId = courseId;
        this.setId(postId);
    }
    private Post(Builder builder) {
        super.setId(builder.postId);
        courseId = builder.courseId;
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

    public CourseId getCourseId() {
        return courseId;
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

    public UserId getCreatedBy() {
        return createdBy;
    }

    public UserId getUpdatedBy() {
        return updatedBy;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static final class Builder {
        private PostId postId;
        private CourseId courseId;
        private String title;
        private String content;
        private String summary;
        private Boolean isPublished;
        private UserId createdBy;
        private UserId updatedBy;
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

        public Builder courseId(CourseId val) {
            courseId = val;
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

        public Builder createdBy(UserId val) {
            createdBy = val;
            return this;
        }

        public Builder updatedBy(UserId val) {
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
