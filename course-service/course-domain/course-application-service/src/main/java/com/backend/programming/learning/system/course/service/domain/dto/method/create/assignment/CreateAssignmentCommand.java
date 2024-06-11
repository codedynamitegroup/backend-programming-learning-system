package com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment;

import com.backend.programming.learning.system.course.service.domain.valueobject.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateAssignmentCommand {
    @NotNull
    private final UUID courseId;

    @NotNull
    private final String title;

    private final String intro;

    private final String activity;

    private final String wordLimit;
    private final String maxUploadFiles;
    private final String maxFileSize;

    @NotNull
    private final Float maxScore;

    @NotNull
    private final ZonedDateTime timeOpen;

    @NotNull
    private final ZonedDateTime timeClose;

    @NotNull
    private final Boolean allowSubmitLate;


    @NotNull(message = "type is required")
    @EnumValidator(enumClass = Type.class, message = "Type is invalid")
    private final String type;

    private final Boolean visible;

}
