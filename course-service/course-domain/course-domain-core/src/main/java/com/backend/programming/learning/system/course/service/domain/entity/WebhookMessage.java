package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.domain.valueobject.WebhookEventName;

import java.time.ZonedDateTime;
import java.util.Map;

public class WebhookMessage {
    private final WebhookEventName eventName;
    private final String component;
    private final String action;
    private final String target;
    private final String objectId; // Database table name which represents the event object to the best. Never use a relationship table here.
    private final String objectTable; // Id of the object record from objecttable.
    private final String crud; // 'c'reate, 'r'ead, 'u'pdate or 'd'elete
    private final String eduLevel;
    private final String contextId;
    private final String contextLevel; //  if it was a course, activity, course category, etc.
    private final String contextInstanceId; // Based on context level this may be course id , course module id, course category, etc.
    private final String userId; // User ID, or 0 when not logged in, or -1 when other
    private final String courseId; // This is used only for contexts at and bellow course level - this can be used to filter events by course
    private final String relatedUserId; // Is this action related to some user?
    private final String anonymous; // Is this action anonymous?
    private final Map<String, Object> other;
    private final ZonedDateTime timeCreated;
    private final String host;
    private final String token;
    private final String extra;

    private WebhookMessage(Builder builder) {
        eventName = builder.eventName;
        component = builder.component;
        action = builder.action;
        target = builder.target;
        objectId = builder.objectId;
        objectTable = builder.objectTable;
        crud = builder.crud;
        eduLevel = builder.eduLevel;
        contextId = builder.contextId;
        contextLevel = builder.contextLevel;
        contextInstanceId = builder.contextInstanceId;
        userId = builder.userId;
        courseId = builder.courseId;
        relatedUserId = builder.relatedUserId;
        anonymous = builder.anonymous;
        other = builder.other;
        timeCreated = builder.timeCreated;
        host = builder.host;
        token = builder.token;
        extra = builder.extra;
    }

    public static Builder builder() {
        return new Builder();
    }

    public WebhookEventName getEventName() {
        return eventName;
    }

    public String getComponent() {
        return component;
    }

    public String getAction() {
        return action;
    }

    public String getTarget() {
        return target;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getObjectTable() {
        return objectTable;
    }

    public String getCrud() {
        return crud;
    }

    public String getEduLevel() {
        return eduLevel;
    }

    public String getContextId() {
        return contextId;
    }

    public String getContextLevel() {
        return contextLevel;
    }

    public String getContextInstanceId() {
        return contextInstanceId;
    }

    public String getUserId() {
        return userId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getRelatedUserId() {
        return relatedUserId;
    }

    public String getAnonymous() {
        return anonymous;
    }

    public Map<String, Object> getOther() {
        return other;
    }

    public ZonedDateTime getTimeCreated() {
        return timeCreated;
    }

    public String getHost() {
        return host;
    }

    public String getToken() {
        return token;
    }

    public String getExtra() {
        return extra;
    }


    public static final class Builder {
        private WebhookEventName eventName;
        private String component;
        private String action;
        private String target;
        private String objectId;
        private String objectTable;
        private String crud;
        private String eduLevel;
        private String contextId;
        private String contextLevel;
        private String contextInstanceId;
        private String userId;
        private String courseId;
        private String relatedUserId;
        private String anonymous;
        private Map<String, Object> other;
        private ZonedDateTime timeCreated;
        private String host;
        private String token;
        private String extra;

        private Builder() {
        }

        public Builder eventName(WebhookEventName val) {
            eventName = val;
            return this;
        }

        public Builder component(String val) {
            component = val;
            return this;
        }

        public Builder action(String val) {
            action = val;
            return this;
        }

        public Builder target(String val) {
            target = val;
            return this;
        }

        public Builder objectId(String val) {
            objectId = val;
            return this;
        }

        public Builder objectTable(String val) {
            objectTable = val;
            return this;
        }

        public Builder crud(String val) {
            crud = val;
            return this;
        }

        public Builder eduLevel(String val) {
            eduLevel = val;
            return this;
        }

        public Builder contextId(String val) {
            contextId = val;
            return this;
        }

        public Builder contextLevel(String val) {
            contextLevel = val;
            return this;
        }

        public Builder contextInstanceId(String val) {
            contextInstanceId = val;
            return this;
        }

        public Builder userId(String val) {
            userId = val;
            return this;
        }

        public Builder courseId(String val) {
            courseId = val;
            return this;
        }

        public Builder relatedUserId(String val) {
            relatedUserId = val;
            return this;
        }

        public Builder anonymous(String val) {
            anonymous = val;
            return this;
        }

        public Builder other(Map<String, Object> val) {
            other = val;
            return this;
        }

        public Builder timeCreated(ZonedDateTime val) {
            timeCreated = val;
            return this;
        }

        public Builder host(String val) {
            host = val;
            return this;
        }

        public Builder token(String val) {
            token = val;
            return this;
        }

        public Builder extra(String val) {
            extra = val;
            return this;
        }

        public WebhookMessage build() {
            return new WebhookMessage(this);
        }
    }
}
