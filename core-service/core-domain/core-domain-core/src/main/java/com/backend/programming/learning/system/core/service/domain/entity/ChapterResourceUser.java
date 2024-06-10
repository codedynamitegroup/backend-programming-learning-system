package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterResourceId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterResourceUserId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ResourceType;
import com.backend.programming.learning.system.domain.entity.BaseEntity;

import java.util.UUID;

public class ChapterResourceUser extends BaseEntity<ChapterResourceUserId> {
    private UUID chapterResourceId;
    private UUID userId;
    private Boolean isViewed;

    private ChapterResourceUser(Builder builder) {
       super.setId(builder.chapterResourceUserId);
        setChapterResourceId(builder.chapterResourceId);
        setUserId(builder.userId);
        isViewed = builder.isViewed;
    }

    public static Builder builder() {
        return new Builder();
    }


    public UUID getChapterResourceId() {
        return chapterResourceId;
    }

    public void setChapterResourceId(UUID chapterResourceId) {
        this.chapterResourceId = chapterResourceId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Boolean getViewed() {
        return isViewed;
    }

    public void setViewed(Boolean viewed) {
        isViewed = viewed;
    }

    public static final class Builder {
        private ChapterResourceUserId chapterResourceUserId;
        private UUID chapterResourceId;
        private UUID userId;
        private Boolean isViewed;

        private Builder() {
        }

        public Builder id(ChapterResourceUserId val) {
            chapterResourceUserId = val;
            return this;
        }

        public Builder chapterResourceId(UUID val) {
            chapterResourceId = val;
            return this;
        }

        public Builder userId(UUID val) {
            userId = val;
            return this;
        }

        public Builder isViewed(Boolean val) {
            isViewed = val;
            return this;
        }

        public ChapterResourceUser build() {
            return new ChapterResourceUser(this);
        }
    }
}
