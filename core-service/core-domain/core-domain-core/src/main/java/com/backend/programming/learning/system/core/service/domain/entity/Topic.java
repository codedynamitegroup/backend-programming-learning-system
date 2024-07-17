package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.ReviewId;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Topic extends AggregateRoot<TopicId> {
    private String name;
    private String description;
    private String thumbnailUrl;
    private Boolean isSingleProgrammingLanguage;
    private List<ProgrammingLanguage> programmingLanguages;
    private Integer numOfCertificateCourses;
    private User createdBy;
    private User updatedBy;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private Topic(Builder builder) {
        super.setId(builder.topicId);
        setName(builder.name);
        setDescription(builder.description);
        setThumbnailUrl(builder.thumbnailUrl);
        isSingleProgrammingLanguage = builder.isSingleProgrammingLanguage;
        setProgrammingLanguages(builder.programmingLanguages);
        setNumOfCertificateCourses(builder.numOfCertificateCourses);
        setCreatedBy(builder.createdBy);
        setUpdatedBy(builder.updatedBy);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
    }

    public static Builder builder() {
        return new Builder();
    }

    public void initializeTopic() {
        setId(new TopicId(UUID.randomUUID()));
        programmingLanguages = new ArrayList<>();
        createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
        updatedAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsSingleProgrammingLanguage(Boolean isSingleProgrammingLanguage) {
        this.isSingleProgrammingLanguage = isSingleProgrammingLanguage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Boolean getSingleProgrammingLanguage() {
        return isSingleProgrammingLanguage;
    }

    public void setSingleProgrammingLanguage(Boolean singleProgrammingLanguage) {
        isSingleProgrammingLanguage = singleProgrammingLanguage;
    }

    public List<ProgrammingLanguage> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(List<ProgrammingLanguage> programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public Integer getNumOfCertificateCourses() {
        return numOfCertificateCourses;
    }

    public void setNumOfCertificateCourses(Integer numOfCertificateCourses) {
        this.numOfCertificateCourses = numOfCertificateCourses;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static final class Builder {
        private TopicId topicId;
        private String name;
        private String description;
        private String thumbnailUrl;
        private Boolean isSingleProgrammingLanguage;
        private List<ProgrammingLanguage> programmingLanguages;
        private Integer numOfCertificateCourses;
        private User createdBy;
        private User updatedBy;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;

        private Builder() {
        }

        public Builder id(TopicId val) {
            topicId = val;
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

        public Builder thumbnailUrl(String val) {
            thumbnailUrl = val;
            return this;
        }

        public Builder isSingleProgrammingLanguage(Boolean val) {
            isSingleProgrammingLanguage = val;
            return this;
        }

        public Builder programmingLanguages(List<ProgrammingLanguage> val) {
            programmingLanguages = val;
            return this;
        }

        public Builder numOfCertificateCourses(Integer val) {
            numOfCertificateCourses = val;
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

        public Topic build() {
            return new Topic(this);
        }
    }
}
