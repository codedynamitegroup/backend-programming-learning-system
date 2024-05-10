package com.backend.programming.learning.system.course.service.domain.dto.method.webhook;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.Map;

@Getter
@Builder
@AllArgsConstructor
public class WebhookCommand {
    @NotNull
    private final String eventname;

    @NotNull
    private final String component;

    @NotNull
    private final String action;

    @NotNull
    private final String target;

    private final String objectid; // Database table name which represents the event object to the best. Never use a relationship table here.
    private final String objecttable; // Id of the object record from objecttable.

    private final String crud; // 'c'reate, 'r'ead, 'u'pdate or 'd'elete
    private final String edulevel;

    @NotNull
    private final String contextid;
    @NotNull
    private final String contextlevel; //  if it was a course, activity, course category, etc.

    @NotNull
    private final String contextinstanceid; // Based on context level this may be course id , course module id, course category, etc.

    @NotNull
    private final String userid; // User ID, or 0 when not logged in, or -1 when other

    @NotNull
    private final String courseid; // This is used only for contexts at and bellow course level - this can be used to filter events by course

    private final String relateduserid; // Is this action related to some user?
    private final String anonymous; // Is this action anonymous?
    private final Map<String, Object> other;

    @NotNull
    private final ZonedDateTime timecreated;

    @NotNull
    private final String host;

    private final String token;
    private final String extra;
}
