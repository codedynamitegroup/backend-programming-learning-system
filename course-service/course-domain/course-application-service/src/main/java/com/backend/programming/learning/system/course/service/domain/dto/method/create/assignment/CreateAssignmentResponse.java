package com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateAssignmentResponse {
    @NotNull
    private final UUID assignmentId;

    @NotNull
    private final String name;

    @NotNull
    private final String message;

}
