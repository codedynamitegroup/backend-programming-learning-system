package com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapterResource;

import com.backend.programming.learning.system.core.service.domain.valueobject.ResourceType;

public class ChapterResourceCount {
    private ResourceType resourceType;
    private Long count;

    private ChapterResourceCount(Builder builder) {
        resourceType = builder.resourceType;
        count = builder.count;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public Long getCount() {
        return count;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private ResourceType resourceType;
        private Long count;

        private Builder() {
        }

        public Builder resourceType(ResourceType val) {
            resourceType = val;
            return this;
        }

        public Builder count(Long val) {
            count = val;
            return this;
        }

        public ChapterResourceCount build() {
            return new ChapterResourceCount(this);
        }
    }
}
