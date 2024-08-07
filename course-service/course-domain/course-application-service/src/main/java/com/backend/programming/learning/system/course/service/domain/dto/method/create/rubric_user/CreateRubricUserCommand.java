package com.backend.programming.learning.system.course.service.domain.dto.method.create.rubric_user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateRubricUserCommand {
    @NotNull
    private final String userId;

    @NotNull
    private final String rubricName;

    private final String rubricDescription;

    @NotNull
    private final String rubricContent;
}
