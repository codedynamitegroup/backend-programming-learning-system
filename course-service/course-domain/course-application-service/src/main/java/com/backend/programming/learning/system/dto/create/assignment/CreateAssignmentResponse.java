package com.backend.programming.learning.system.dto.create.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
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
