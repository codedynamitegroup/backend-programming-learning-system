package com.backend.programming.learning.system.dto.method.create.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCourseCommand {

    @NotNull(message = "Name is required")
    private final String name;

//    @NotNull
    private final String key;

    @NotNull(message = "Visible is required")
    private final Boolean visible;
    @NotNull(message = "Created by is required")
    private final UUID createdBy;
}
