package com.backend.programming.learning.system.dto.delete.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteAssignmentResponse {
    @NotNull
    private final UUID assignmentId;

    @NotNull
    private final String message;

}
