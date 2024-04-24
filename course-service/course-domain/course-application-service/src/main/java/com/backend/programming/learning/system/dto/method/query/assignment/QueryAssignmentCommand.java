package com.backend.programming.learning.system.dto.method.query.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAssignmentCommand {
    @NotNull
    private final UUID assignmentId;
}
