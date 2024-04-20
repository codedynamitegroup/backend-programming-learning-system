package com.backend.programming.learning.system.dto.method.create.assignment;

import com.backend.programming.learning.system.valueobject.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;

import javax.validation.constraints.NotNull;
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

    @NotNull
    private final String intro;

    @NotNull
    private final Float score;

    @NotNull
    private final Float maxScore;

    @NotNull
    private final ZonedDateTime timeOpen;

    @NotNull
    private final ZonedDateTime timeClose;

    @NotNull
    private final ZonedDateTime timeLimit;

    @NotNull(message = "type is required")
    @EnumValidator(enumClass = Type.class, message = "Type is invalid")
    private final String type;

    @NotNull
    private final Boolean visible;

}
