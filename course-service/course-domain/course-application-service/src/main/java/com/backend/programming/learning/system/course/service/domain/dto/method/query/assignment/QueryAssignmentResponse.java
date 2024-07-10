package com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.intro_attachment.IntroAttachmentResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAssignmentResponse {

    @NotNull
    private final UUID id;

    private final String courseName;

    private final Integer moodleId;

    @NotNull
    private final String title;

    private final String intro;

    private final List<IntroAttachmentResponseEntity> introAttachments;

    private final String activity;

    @NotNull
    private final Float maxScore;

    private final String wordLimit;

    private final String maxUploadFiles;

    private final String maxFileSize;

    @NotNull
    private final ZonedDateTime timeOpen;

    @NotNull
    private final ZonedDateTime timeClose;

    @NotNull
    private final String type;

    @NotNull
    private final Boolean visible;

    @NotNull
    private Boolean allowSubmitLate;

}
