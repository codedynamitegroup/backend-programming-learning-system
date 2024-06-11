package com.backend.programming.learning.system.core.service.domain.entity;

import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterResourceId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ResourceType;
import com.backend.programming.learning.system.domain.entity.BaseEntity;

import java.util.UUID;

public class ChapterResource extends BaseEntity<ChapterResourceId> {
    private Chapter chapter;
    private Integer no;
    private ResourceType resourceType;
    private Question question;
    private UUID codeQuestionId;
    private String title;
    private String lessonHtml;
    private String youtubeVideoUrl;
    private Boolean isCompleted;

    private ChapterResource(Builder builder) {
        super.setId(builder.chapterResourceId);
        setChapter(builder.chapter);
        setNo(builder.no);
        setResourceType(builder.resourceType);
        setQuestion(builder.question);
        setCodeQuestionId(builder.codeQuestionId);
        setTitle(builder.title);
        setLessonHtml(builder.lessonHtml);
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

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
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

    public UUID getCodeQuestionId() {
        return codeQuestionId;
    }

    public void setCodeQuestionId(UUID codeQuestionId) {
        this.codeQuestionId = codeQuestionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLessonHtml() {
        return lessonHtml;
    }

    public void setLessonHtml(String lessonHtml) {
        this.lessonHtml = lessonHtml;
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
        private Integer no;
        private ResourceType resourceType;
        private Question question;
        private UUID codeQuestionId;
        private String title;
        private String lessonHtml;
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

        public Builder no(Integer val) {
            no = val;
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

        public Builder codeQuestionId(UUID val) {
            codeQuestionId = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder lessonHtml(String val) {
            lessonHtml = val;
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
