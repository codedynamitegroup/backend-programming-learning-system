package com.backend.programming.learning.system.course.service.domain.dto.method.create.call_moodle_api_function;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateCallMoodleApiFunctionCommand {
    @NotNull
    private final String area;

    @NotNull
    private final String name;

    @NotNull
    private final String description;
}
