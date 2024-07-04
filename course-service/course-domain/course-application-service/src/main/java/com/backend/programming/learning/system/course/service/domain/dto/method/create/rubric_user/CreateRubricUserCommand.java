package com.backend.programming.learning.system.course.service.domain.dto.method.create.rubric_user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.query.question
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 2:23 AM
 * Description: ...
 */
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
