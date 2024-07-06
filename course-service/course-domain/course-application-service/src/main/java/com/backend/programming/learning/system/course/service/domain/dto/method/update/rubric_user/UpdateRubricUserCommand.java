package com.backend.programming.learning.system.course.service.domain.dto.method.update.rubric_user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UpdateRubricUserCommand {
    @NotNull
    private final String rubricUserId;

    private final String rubricName;

    private final String rubricDescription;

    private final String rubricContent;
}
