package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterResourceId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ResourceType;
import com.backend.programming.learning.system.domain.entity.BaseEntity;

public class ChapterResource extends BaseEntity<ChapterResourceId> {
    private Chapter chapter;
    private ResourceType resourceType;
    private Question question;
    private String lessonTitle;
    private String lessonHtml;
    private String videoTitle;
    private String youtubeVideoUrl;
    private Boolean isCompleted;

    private ChapterResource(Builder builder) {
        super.setId(builder.chapterResourceId);
        setChapter(builder.chapter);
        setResourceType(builder.resourceType);
        setQuestion(builder.question);
        setLessonTitle(builder.lessonTitle);
        setLessonHtml(builder.lessonHtml);
        setVideoTitle(builder.videoTitle);
        setYoutubeVideoUrl(builder.youtubeVideoUrl);
        isCompleted = builder.isCompleted;
    }

    public static Builder builder() {
        return new Builder();
    }


    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getLessonHtml() {
        return lessonHtml;
    }

    public void setLessonHtml(String lessonHtml) {
        this.lessonHtml = lessonHtml;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getYoutubeVideoUrl() {
        return youtubeVideoUrl;
    }

    public void setYoutubeVideoUrl(String youtubeVideoUrl) {
        this.youtubeVideoUrl = youtubeVideoUrl;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public static final class Builder {
        private ChapterResourceId chapterResourceId;
        private Chapter chapter;
        private ResourceType resourceType;
        private Question question;
        private String lessonTitle;
        private String lessonHtml;
        private String videoTitle;
        private String youtubeVideoUrl;
        private Boolean isCompleted;

        private Builder() {
        }

        public Builder id(ChapterResourceId val) {
            chapterResourceId = val;
            return this;
        }

        public Builder chapter(Chapter val) {
            chapter = val;
            return this;
        }

        public Builder resourceType(ResourceType val) {
            resourceType = val;
            return this;
        }

        public Builder question(Question val) {
            question = val;
            return this;
        }

        public Builder lessonTitle(String val) {
            lessonTitle = val;
            return this;
        }

        public Builder lessonHtml(String val) {
            lessonHtml = val;
            return this;
        }

        public Builder videoTitle(String val) {
            videoTitle = val;
            return this;
        }

        public Builder youtubeVideoUrl(String val) {
            youtubeVideoUrl = val;
            return this;
        }

        public Builder isCompleted(Boolean val) {
            isCompleted = val;
            return this;
        }

        public ChapterResource build() {
            return new ChapterResource(this);
        }
    }
}
