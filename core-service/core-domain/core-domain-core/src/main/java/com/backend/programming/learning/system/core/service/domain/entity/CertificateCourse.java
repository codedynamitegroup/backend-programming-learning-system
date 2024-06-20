package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CertificateCourse extends AggregateRoot<CertificateCourseId> {
    private String name;
    private String description;
    private SkillLevel skillLevel;
    private Float avgRating;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private Integer numOfStudents;
    private Integer numOfResources;
    private Integer numOfCompletedResources;
    private ChapterResource currentResource;
    private Integer numOfReviews;
    private Boolean isRegistered;
    private Topic topic;
    private User createdBy;
    private User updatedBy;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private List<CertificateCourseUser> certificateCourseUsers;
    private Integer numOfOneStarReviews;
    private Integer numOfTwoStarReviews;
    private Integer numOfThreeStarReviews;
    private Integer numOfFourStarReviews;
    private Integer numOfFiveStarReviews;

    private CertificateCourse(Builder builder) {
        super.setId(builder.certificateCourseId);
        setName(builder.name);
        setDescription(builder.description);
        setSkillLevel(builder.skillLevel);
        setAvgRating(builder.avgRating);
        setStartTime(builder.startTime);
        setEndTime(builder.endTime);
        setNumOfStudents(builder.numOfStudents);
        setNumOfResources(builder.numOfResources);
        setNumOfCompletedResources(builder.numOfCompletedResources);
        setCurrentResource(builder.currentResource);
        setNumOfReviews(builder.numOfReviews);
        isRegistered = builder.isRegistered;
        setTopic(builder.topic);
        setCreatedBy(builder.createdBy);
        setUpdatedBy(builder.updatedBy);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
        setCertificateCourseUsers(builder.certificateCourseUsers);
        setNumOfOneStarReviews(builder.numOfOneStarReviews);
        setNumOfTwoStarReviews(builder.numOfTwoStarReviews);
        setNumOfThreeStarReviews(builder.numOfThreeStarReviews);
        setNumOfFourStarReviews(builder.numOfFourStarReviews);
        setNumOfFiveStarReviews(builder.numOfFiveStarReviews);
    }

    public static Builder builder() {
        return new Builder();
    }

    public void initializeCertificateCourse() {
        setId(new CertificateCourseId(UUID.randomUUID()));
        certificateCourseUsers = new ArrayList<>();
        setCreatedAt(ZonedDateTime.now(ZoneId.of("UTC")));
        setUpdatedAt(ZonedDateTime.now(ZoneId.of("UTC")));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    public Float getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Float avgRating) {
        this.avgRating = avgRating;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getNumOfStudents() {
        return numOfStudents;
    }

    public void setNumOfStudents(Integer numOfStudents) {
        this.numOfStudents = numOfStudents;
    }

    public Integer getNumOfResources() {
        return numOfResources;
    }

    public void setNumOfResources(Integer numOfResources) {
        this.numOfResources = numOfResources;
    }

    public Integer getNumOfCompletedResources() {
        return numOfCompletedResources;
    }

    public void setNumOfCompletedResources(Integer numOfCompletedResources) {
        this.numOfCompletedResources = numOfCompletedResources;
    }

    public ChapterResource getCurrentResource() {
        return currentResource;
    }

    public void setCurrentResource(ChapterResource currentResource) {
        this.currentResource = currentResource;
    }

    public Integer getNumOfReviews() {
        return numOfReviews;
    }

    public void setNumOfReviews(Integer numOfReviews) {
        this.numOfReviews = numOfReviews;
    }

    public Boolean getRegistered() {
        return isRegistered;
    }

    public void setRegistered(Boolean registered) {
        isRegistered = registered;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
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

    public List<CertificateCourseUser> getCertificateCourseUsers() {
        return certificateCourseUsers;
    }

    public void setCertificateCourseUsers(List<CertificateCourseUser> certificateCourseUsers) {
        this.certificateCourseUsers = certificateCourseUsers;
    }

    public Integer getNumOfOneStarReviews() {
        return numOfOneStarReviews;
    }

    public void setNumOfOneStarReviews(Integer numOfOneStarReviews) {
        this.numOfOneStarReviews = numOfOneStarReviews;
    }

    public Integer getNumOfTwoStarReviews() {
        return numOfTwoStarReviews;
    }

    public void setNumOfTwoStarReviews(Integer numOfTwoStarReviews) {
        this.numOfTwoStarReviews = numOfTwoStarReviews;
    }

    public Integer getNumOfThreeStarReviews() {
        return numOfThreeStarReviews;
    }

    public void setNumOfThreeStarReviews(Integer numOfThreeStarReviews) {
        this.numOfThreeStarReviews = numOfThreeStarReviews;
    }

    public Integer getNumOfFourStarReviews() {
        return numOfFourStarReviews;
    }

    public void setNumOfFourStarReviews(Integer numOfFourStarReviews) {
        this.numOfFourStarReviews = numOfFourStarReviews;
    }

    public Integer getNumOfFiveStarReviews() {
        return numOfFiveStarReviews;
    }

    public void setNumOfFiveStarReviews(Integer numOfFiveStarReviews) {
        this.numOfFiveStarReviews = numOfFiveStarReviews;
    }

    public static final class Builder {
        private CertificateCourseId certificateCourseId;
        private String name;
        private String description;
        private SkillLevel skillLevel;
        private Float avgRating;
        private ZonedDateTime startTime;
        private ZonedDateTime endTime;
        private Integer numOfStudents;
        private Integer numOfResources;
        private Integer numOfCompletedResources;
        private ChapterResource currentResource;
        private Integer numOfReviews;
        private Boolean isRegistered;
        private Topic topic;
        private User createdBy;
        private User updatedBy;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private List<CertificateCourseUser> certificateCourseUsers;
        private Integer numOfOneStarReviews;
        private Integer numOfTwoStarReviews;
        private Integer numOfThreeStarReviews;
        private Integer numOfFourStarReviews;
        private Integer numOfFiveStarReviews;

        private Builder() {
        }

        public Builder id(CertificateCourseId val) {
            certificateCourseId = val;
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

        public Builder skillLevel(SkillLevel val) {
            skillLevel = val;
            return this;
        }

        public Builder avgRating(Float val) {
            avgRating = val;
            return this;
        }

        public Builder startTime(ZonedDateTime val) {
            startTime = val;
            return this;
        }

        public Builder endTime(ZonedDateTime val) {
            endTime = val;
            return this;
        }

        public Builder numOfStudents(Integer val) {
            numOfStudents = val;
            return this;
        }

        public Builder numOfResources(Integer val) {
            numOfResources = val;
            return this;
        }

        public Builder numOfCompletedResources(Integer val) {
            numOfCompletedResources = val;
            return this;
        }

        public Builder currentResource(ChapterResource val) {
            currentResource = val;
            return this;
        }

        public Builder numOfReviews(Integer val) {
            numOfReviews = val;
            return this;
        }

        public Builder isRegistered(Boolean val) {
            isRegistered = val;
            return this;
        }

        public Builder topic(Topic val) {
            topic = val;
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

        public Builder certificateCourseUsers(List<CertificateCourseUser> val) {
            certificateCourseUsers = val;
            return this;
        }

        public Builder numOfOneStarReviews(Integer val) {
            numOfOneStarReviews = val;
            return this;
        }

        public Builder numOfTwoStarReviews(Integer val) {
            numOfTwoStarReviews = val;
            return this;
        }

        public Builder numOfThreeStarReviews(Integer val) {
            numOfThreeStarReviews = val;
            return this;
        }

        public Builder numOfFourStarReviews(Integer val) {
            numOfFourStarReviews = val;
            return this;
        }

        public Builder numOfFiveStarReviews(Integer val) {
            numOfFiveStarReviews = val;
            return this;
        }

        public CertificateCourse build() {
            return new CertificateCourse(this);
        }
    }
}
